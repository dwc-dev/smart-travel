# smart-travel 后端

## 编译

```bash
mvn package
docker build -t smart-travel .
```

## 导出image

```bash
docker save smart-travel > smart-travel.tar
```

## 运行

```bash
docker run -d \
  --name smart-travel \
  -p your_port:8080 \
  -v your_volume:/data \
  --env DB_DATABASE=your_db_name \
  --env DB_HOST=your_db_host \
  --env DB_PORT=your_db_port \
  --env DB_USERNAME=your_db_username \
  --env DB_PASSWORD=your_db_password \
  --env REDIS_DATABASE=your_redis_db \
  --env REDIS_HOST=your_redis_host \
  --env REDIS_PORT=your_redis_port \
  --env REDIS_PASSWORD=your_redis_password \
  --env TOKEN_PASSWORD=your_token_password \
  --restart always \
  smart-travel
```
