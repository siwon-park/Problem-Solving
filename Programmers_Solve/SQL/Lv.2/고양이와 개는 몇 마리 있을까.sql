-- 동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성. 이때 고양이를 개보다 먼저 조회해야함
-- GROUP BY 다음에 ORDER BY를 쓰는 순서를 잊지말자
SELECT ANIMAL_TYPE, COUNT(*) AS 'count' FROM ANIMAL_INS GROUP BY ANIMAL_TYPE ORDER BY ANIMAL_TYPE ASC;
