
UPDATE `sign_up`.`student` 
SET  `name` = '王小二' 
WHERE `id` = 500000;

UPDATE `sign_up`.`student` 
SET  `name` = '王小二' 
WHERE `id` = 15000000;

UPDATE `sign_up`.`student` 
SET  `name` = '王小二' 
WHERE `id` = 100000000;


ALTER TABLE `sign_up`.`student`
ADD INDEX idx_name(name);

SELECT * 
FROM student 
WHERE name="王小二";

