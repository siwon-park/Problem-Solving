-- 코드를 입력하세요
-- 동물 보호소에 들어온 동물 중 아픈 동물(WHERE INTAKE_CONDITION = 'Sick')의 아이디와 이름(ANIMAL_ID, NAME)을 조회. 이때 결과는 아이디 순으로 조회(ORDER BY ANIMAL_ID)
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION = 'Sick' ORDER BY ANIMAL_ID;
