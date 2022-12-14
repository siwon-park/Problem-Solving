-- 중성화 여부 파악하기
-- CASE, WHEN, THEN 구문이라는 것을 처음 알게 되었다.
-- INSTR을 써서 부분 문자열인지 판별하였고
-- 마지막에 조건에 부합하지 않으면 ELSE 처리하였다.
-- 또한 칼럼명을 바꾸기 위해 END 이후 AS로 처리하여 칼럼명을 변경하였다.
SELECT ANIMAL_ID, NAME,
CASE
WHEN SEX_UPON_INTAKE LIKE 'Neutered%' THEN 'O'
WHEN INSTR(SEX_UPON_INTAKE, 'Spayed') THEN 'O'
ELSE 'X'
END AS "중성화"
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;
