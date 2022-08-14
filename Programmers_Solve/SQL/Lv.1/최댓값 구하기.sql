-- 가장 최근에 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성하시오
-- DATETIME을 기준으로 오름차순 정렬하여 1개를 뽑음
SELECT DATETIME FROM ANIMAL_INS ORDER BY DATETIME DESC LIMIT 1;
