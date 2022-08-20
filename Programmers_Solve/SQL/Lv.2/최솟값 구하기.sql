-- 동물 보호소에 가장 먼저 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성
-- ANIMAL_INS에서 DATETIME을 오름차순으로 정렬하여 제일 위에 있는 1개를 출력
SELECT DATETIME FROM ANIMAL_INS ORDER BY DATETIME ASC LIMIT 1;
