-- 用户表：存储所有类型用户的信息
CREATE TABLE travel_user
(
    user_id     INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
    username    VARCHAR(50)                                   NOT NULL COMMENT '用户名',
    password    VARCHAR(255)                                  NOT NULL COMMENT '密码',
    role        ENUM ('售票管理员', '内容管理员', '普通用户') NOT NULL COMMENT '用户角色',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT = '用户表，存储所有类型用户的信息';

-- 景区表：存储景区信息
CREATE TABLE travel_scenic
(
    scenic_id        INT AUTO_INCREMENT PRIMARY KEY COMMENT '景区ID',
    name             VARCHAR(100) NOT NULL COMMENT '景区名称',
    province         VARCHAR(50)  NOT NULL COMMENT '省',
    city             VARCHAR(50)  NOT NULL COMMENT '市',
    district         VARCHAR(50)  NOT NULL COMMENT '区',
    description      TEXT COMMENT '景区简介',
    image_url        VARCHAR(255) COMMENT '景区图片URL',
    create_time      TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    image_width      INT COMMENT '景区图片宽度',
    image_height     INT COMMENT '景区图片高度',
    image_main_color VARCHAR(50) COMMENT '景区图片主色'
) COMMENT = '景区表，存储景区信息';

-- 票务表：存储票的数量和价格等信息
CREATE TABLE travel_ticket
(
    ticket_id   INT AUTO_INCREMENT PRIMARY KEY COMMENT '票务ID',
    scenic_id   INT            NOT NULL COMMENT '景区ID',
    quantity    INT            NOT NULL COMMENT '票的数量',
    type        INT            NOT NULL COMMENT '票的类型',
    price       DECIMAL(10, 2) NOT NULL COMMENT '票的价格',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT = '票务表，存储票的数量和价格等信息';

-- 订单表：存储用户的购票信息
CREATE TABLE travel_order
(
    order_id    INT AUTO_INCREMENT PRIMARY KEY COMMENT '订单ID',
    user_id     INT            NOT NULL COMMENT '用户ID',
    ticket_id   INT            NOT NULL COMMENT '票务ID',
    quantity    INT            NOT NULL COMMENT '购票数量',
    total_price DECIMAL(10, 2) NOT NULL COMMENT '总价',
    order_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间'
) COMMENT = '订单表，存储用户的购票信息';

-- 设施表：存储景区设施信息
CREATE TABLE travel_facility
(
    facility_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '设施ID',
    scenic_id   INT          NOT NULL COMMENT '景点ID',
    name        VARCHAR(255) NOT NULL COMMENT '设施名称',
    type        VARCHAR(255) NOT NULL COMMENT '设施类型',
    description TEXT COMMENT '设施描述',
    FOREIGN KEY (scenic_id) REFERENCES travel_scenic (scenic_id)
) COMMENT ='景区设施表';

-- 活动表：存储景区活动信息
CREATE TABLE travel_event
(
    event_id    INT AUTO_INCREMENT PRIMARY KEY COMMENT '活动ID',
    scenic_id   INT          NOT NULL COMMENT '景区ID',
    name        VARCHAR(255) NOT NULL COMMENT '活动名称',
    start_time  DATETIME     NOT NULL COMMENT '开始时间',
    end_time    DATETIME     NOT NULL COMMENT '结束时间',
    description TEXT COMMENT '活动描述',
    FOREIGN KEY (scenic_id) REFERENCES travel_scenic (scenic_id)
) COMMENT ='景区活动表';

-- 广告表：存储景区广告信息
CREATE TABLE travel_advertisement
(
    ad_id      INT AUTO_INCREMENT PRIMARY KEY COMMENT '广告ID',
    scenic_id  INT          NOT NULL COMMENT '景区ID',
    title      VARCHAR(255) NOT NULL COMMENT '广告标题',
    content    TEXT COMMENT '广告内容',
    start_time DATETIME     NOT NULL COMMENT '开始时间',
    end_time   DATETIME     NOT NULL COMMENT '结束时间',
    FOREIGN KEY (scenic_id) REFERENCES travel_scenic (scenic_id)
) COMMENT '景区广告表';

-- 交通信息表
CREATE TABLE travel_transport
(
    transport_id      INT AUTO_INCREMENT PRIMARY KEY COMMENT '交通ID',
    scenic_id         INT NOT NULL COMMENT '景区ID',
    transport_type    VARCHAR(50) NOT NULL COMMENT '交通类型',
    route_description TEXT COMMENT '交通信息描述',
    FOREIGN KEY (scenic_id) REFERENCES travel_scenic (scenic_id)
) COMMENT = '交通信息表';
