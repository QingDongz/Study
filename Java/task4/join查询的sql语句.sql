-- 1,  普通连接查询，查询所有学生，带职业，注意这是普通查询
SELECT student.name,student.brief_introduce,job.job_name
FROM student,job 
WHERE student.job_id=job.job_id;
-- 2,  本句和 1 一样，只是为表取别名，缩短语句长度
SELECT s.name,s.brief_introduce,j.job_name 
FROM student s,job j 
WHERE s.job_id=j.job_id;

-- 3,  普通连接查询，跟 1、2类似，但是，是查询优秀学生，多加了一个条件。
SELECT s.name,s.brief_introduce,j.job_name 
FROM student s,job j 
WHERE s.job_id=j.job_id AND s.is_excellent=1;

-- 4,  和3类似，但是查询优秀学生的所有字段，直接用*
SELECT s.*,j.job_name 
FROM student s,job j 
WHERE s.job_id=j.job_id AND s.is_excellent=1;

-- 5,  内连接查询，和4效果一致
SELECT s.*,j.job_name 
FROM student s
INNER JOIN job j
ON s.job_id=j.job_id AND s.is_excellent=1;

-- 6， 左连接查询
