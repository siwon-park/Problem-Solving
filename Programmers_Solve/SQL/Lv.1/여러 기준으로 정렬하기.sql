-- 동물 테이블에서 아이디, 이름, 보호일을 뽑는데, 이름은 사전순, 보호일은 내림차순으로 정렬
SELECT ANIMAL_ID, NAME, DATETIME FROM ANIMAL_INS ORDER BY NAME ASC, DATETIME DESC;
