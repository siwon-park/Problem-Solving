-- 이름이 없는(Null) 동물의 이름은 "No name"으로 표시하는 쿼리문을 작성
-- NULL을 처리할 수 있는 방법: IFNULL(칼럼명, 처리할 값) AS (새로운) 칼럼명
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name') AS NAME, SEX_UPON_INTAKE FROM ANIMAL_INS;
