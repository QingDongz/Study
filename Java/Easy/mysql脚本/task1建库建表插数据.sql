CREATE DATABASE `sign_up` 
CHARACTER SET 'utf8' 
COLLATE 'utf8_general_ci';

CREATE TABLE `sign_up`.`student`(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`create_at` bigint(20) NOT NULL,
`update_at` bigint(20) NOT NULL,
`name` varchar(255) NULL,
`qq` varchar(255) NULL,
`type` int(10) NULL,
`entry_time` varchar(255) NULL,
`school` varchar(255) NULL,
`student_id` varchar(255) NULL,
`link` varchar(255) NULL,
`oath` varchar(255) NULL,
`brother` varchar(255) NULL,
`knowfrom` varchar(255) NULL,
PRIMARY KEY (`id`)
);

INSERT INTO `sign_up`.`student`() 
VALUES
(null, NOW(), NOW(), '曲艳行', '3169119846', 1, '11月18日-22日', '燕山大学', 2641, 'http://www.jnshu.com/daily/', '老大最帅', '郑州分院-王鹏举', '知乎'),
(null, NOW(), NOW(), '吴昊杰', '939804509', 2, '2017年12月7日', '天津大学', 4909, 'http://www.jnshu.com/daily/42239', '学会web 努力学习 找到工作', '北京分院-于靖华', NULL),
(null, NOW(), NOW(), '吴磊建', '1143010813', 1, '2017年12月27日~29日', '石家庄铁道大学', 2968, 'http://www.jnshu.com/daily/43557', '不经一番寒彻骨，怎得梅花扑鼻香', '上海分院-蒋新益', '知乎')
;
