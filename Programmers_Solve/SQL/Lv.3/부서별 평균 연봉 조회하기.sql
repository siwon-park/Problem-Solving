-- 부서별 평균 연봉 조회하기
SELECT he.dept_id AS 'DEPT_ID',
hd.dept_name_en AS 'DEPT_NAME_EN',
ROUND(AVG(he.sal), 0) AS 'AVG_SAL'
FROM hr_employees he
JOIN hr_department hd
ON he.dept_id = hd.dept_id
GROUP BY he.dept_id
ORDER BY AVG_SAL DESC;
