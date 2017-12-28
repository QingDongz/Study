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