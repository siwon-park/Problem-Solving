-- 동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL문을 작성
-- 동물이 몇 마리 들어왔는지 확인하려면 테이블의 값이 중복되는 것이 없어야 하므로 동물의 ID를 기준으로 COUNT한다.
-- AS '문자열'로 '문자열'형태의 테이블을 만들 수 있다.
SELECT COUNT(ANIMAL_ID) AS 'count' FROM ANIMAL_INS;
