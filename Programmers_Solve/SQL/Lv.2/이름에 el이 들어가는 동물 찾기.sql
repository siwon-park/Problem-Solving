-- 이름에 el이 들어가는 동물 찾기
-- LIKE에 있는 %는 있을 수도 있고 없을 수도 있다는 의미의 와일드 카드
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE ANIMAL_TYPE = 'Dog' AND NAME LIKE '%EL%' ORDER BY NAME;
