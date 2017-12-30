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

-- 创建生成长度为n的随机字符串的函数
DELIMITER // -- 修改MySQL delimiter：'//'
DROP FUNCTION IF EXISTS `rand_string` //
SET NAMES utf8 //
CREATE FUNCTION `rand_string` (n INT) RETURNS VARCHAR(255) CHARSET 'utf8'
BEGIN 
    DECLARE char_str varchar(100) DEFAULT 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    DECLARE return_str varchar(255) DEFAULT '';
    DECLARE i INT DEFAULT 0;
    WHILE i < n DO
        SET return_str = concat(return_str, substring(char_str, FLOOR(1 + RAND()*62), 1));
        SET i = i+1;
    END WHILE;
    RETURN return_str;
END //

-- 创建插入数据的存储过程
DROP PROCEDURE IF EXISTS `add_vote_record_memory` //
CREATE PROCEDURE `add_vote_record_memory`(IN n INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i < n DO
        INSERT INTO `sign_up`.`student` (`create_at`, `update_at`, `name`, `QQ_id`, `study_type`, `except_entry_time`, `graduted_school`, `student_id`, `report_link`, `oath`, `school_brother`, `from_where_know`) 
        VALUES (NULL,NOW(), rand_string(20), '3169119846', 1, '11月18日--11月22日', '燕山大学', 2641, 'http://www.jnshu.com/daily/40038', '老大最帅', '郑州分院王鹏举', '知乎');
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;  -- 改回默认的 MySQL delimiter：';'

CALL add_vote_record_memory(1000000);