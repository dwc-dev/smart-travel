import os
import pymysql
import requests
from io import BytesIO
from PIL import Image
from colorthief import ColorThief


def get_image_info(image_url):
    try:
        response = requests.get(image_url)
        img = Image.open(BytesIO(response.content))

        image_width, image_height = img.size
        color_thief = ColorThief(BytesIO(response.content))
        main_color = color_thief.get_color(quality=1)
        main_color_hex = "#{:02x}{:02x}{:02x}".format(
            main_color[0], main_color[1], main_color[2]
        )

        return image_width, image_height, main_color_hex
    except Exception as e:
        print(f"Error processing image from URL {image_url}: {e}")
        return None, None, None


def update_image_info(db_config, table_name):
    connection = pymysql.connect(**db_config)
    cursor = connection.cursor()

    query = f"""
        SELECT scenic_id, image_url
        FROM {table_name}
        WHERE image_url IS NOT NULL
        AND (image_width IS NULL OR image_height IS NULL OR image_main_color IS NULL)
    """
    cursor.execute(query)
    rows = cursor.fetchall()

    for row in rows:
        scenic_id = row[0]
        image_url = row[1]

        image_width, image_height, main_color_hex = get_image_info(image_url)

        if (
            image_width is not None
            and image_height is not None
            and main_color_hex is not None
        ):
            print(
                f"Updating image info for {scenic_id}, image_url: {image_url}\n"
                f"image_width: {image_width}, image_height: {image_height}, main_color: {main_color_hex}\n"
            )
            update_sql = f"""
                UPDATE {table_name}
                SET image_width = %s,
                    image_height = %s,
                    image_main_color = %s
                WHERE scenic_id = %s
            """
            cursor.execute(
                update_sql, (image_width, image_height, main_color_hex, scenic_id)
            )
            connection.commit()

    cursor.close()
    connection.close()


if __name__ == "__main__":
    db_config = {
        "host": os.getenv("DB_HOST"),
        "user": os.getenv("DB_USER"),
        "password": os.getenv("DB_PASSWORD"),
        "database": os.getenv("DB_NAME", "ry-vue"),
        "port": int(os.getenv("DB_PORT", 3306)),
        "charset": "utf8mb4",
    }

    table_name = os.getenv("DB_TABLE_NAME", "travel_scenic")

    update_image_info(db_config, table_name)
