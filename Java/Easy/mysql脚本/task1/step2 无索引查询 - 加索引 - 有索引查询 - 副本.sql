UPDATE `sign_up`.`student` 
SET  `name` = '王小二' 
WHERE `id` = 500000;

SELECT * 
FROM student 
WHERE name="王小二";

-- ALTER TABLE `sign_up`.`student` 
-- ADD INDEX `idx_name`(`name`) USING BTREE;

ALTER TABLE `sign_up`.`student`
ADD INDEX idx_name(name);

SELECT * 
FROM student 
WHERE name="王小二";

-- 删除索引
-- ALTER TABLE `sign_up`.`student` 
-- DROP INDEX `idx_name`;