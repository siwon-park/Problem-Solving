-- DATETIME에서 DATE로 형 변환
-- DATE_FORMAT을 사용해서 DATETIME을 DATE로 바꿀 수 있는지 묻는 문제
-- Lv.1 수준인 것 같은데, 옛날 문제라 Lv.2에 있는 것 같다.
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS '날짜'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;
