CREATE TABLE `gmh_order_2022_8` (
  `id` bigint NOT NULL COMMENT '订单Id',
  `order_number` int NOT NULL COMMENT '订单编号',
  `order_code` varchar(255) DEFAULT NULL COMMENT '自提码or券码编号',
  `user_id` int DEFAULT NULL COMMENT '用户Id',
  `user_nickname` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `order_type_id` int DEFAULT NULL COMMENT '订单类型Id',
  `order_type_name` varchar(255) DEFAULT NULL COMMENT '订单类型名称',
  `prepayed_pay_money` decimal(10,2) DEFAULT NULL COMMENT '预付金额',
  `real_pay_money` decimal(10,2) DEFAULT NULL COMMENT '实付金额',
  `pay_method_id` int DEFAULT NULL COMMENT '支付方式Id',
  `pay_method_name` varchar(255) DEFAULT NULL COMMENT '支付方式名称',
  `order_status_id` int DEFAULT NULL COMMENT '订单状态ID',
  `order_status_name` varchar(255) DEFAULT NULL COMMENT '订单状态名称',
  `order_time` datetime DEFAULT NULL COMMENT '下单时间',
  `delivery_method` varchar(255) DEFAULT NULL COMMENT '配送方式',
  `order_total_money` decimal(10,2) DEFAULT NULL COMMENT '订单总金额',
  `coupon_money` decimal(10,2) DEFAULT NULL COMMENT '折扣券金额',
  `freight` decimal(10,2) DEFAULT NULL COMMENT '运费费用',
  `red_envelope_money` decimal(10,2) DEFAULT NULL COMMENT '预计赚取红包金额',
  `receiver_person_name` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `receiver_person_phone` varchar(255) DEFAULT NULL COMMENT '收货人电话',
  `receive_perosn_address` varchar(255) DEFAULT NULL COMMENT '收货人地址',
  `receive_perosn_address_details` varchar(255) DEFAULT NULL COMMENT '收货人详细地址',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci AVG_ROW_LENGTH=32 COMMENT='订单宽表'