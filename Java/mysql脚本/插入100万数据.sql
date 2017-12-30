-- 创建生成长度为n的随机字符串的函数
DELIMITER // -- 修改MySQL delimiter：'//'

-- 创建插入数据的存储过程
DROP PROCEDURE IF EXISTS `add_vote_record_memory` //
CREATE PROCEDURE `add_vote_record_memory`(IN n INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i < n DO
        INSERT INTO `sign_up`.`student` 
        VALUES (NULL,NOW(), NOW(), '曲艳行', '3169119846', 1, '11月18日--11月22日', '燕山大学', 2641, 'http://www.jnshu.com/daily/40038', '老大最帅', '郑州分院王鹏举', '知乎');
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;  -- 改回默认的 MySQL delimiter：';'

CALL add_vote_record_memory(1000000);

