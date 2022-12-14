-- 루시와 엘라 찾기
-- WHERE 절을 사용하는 간단한 문제
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME = 'Ella' OR NAME = 'Lucy' OR NAME = 'Pickle' OR NAME = 'Rogan' OR NAME = 'Sabrina' OR NAME = 'Mitty'
ORDER BY ANIMAL_ID ASC;
