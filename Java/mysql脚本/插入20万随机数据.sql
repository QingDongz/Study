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
        VALUES (NOW(), NOW(), rand_string(20), '3169119846', 'JAVA工程师', '11月18日--11月22日', '燕山大学', 2641, 'http://www.jnshu.com/daily/40038?dailyType=others&total=8&page=1&uid=18143&sort=0&orderBy=3', '老大最帅', '郑州分院王鹏举', '知乎');
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;  -- 改回默认的 MySQL delimiter：';'

CALL add_vote_record_memory(200000);

