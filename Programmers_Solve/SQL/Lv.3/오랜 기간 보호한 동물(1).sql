-- 오랜 기간 보호한 동물(1)
-- 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일 순으로 조회해야 합니다.
-- OUTER JOIN을 사용해야 하는 문제
-- 그 이유는 입양일이 없는 동물의 경우 ANIMAL_OUTS 테이블에 존재하지 않기 때문에
-- JOIN 조건을 만족하지 않더라도 JOIN이 되어야 하기 때문이다.
-- LIMIT과 OFFEST이 모든 구문의 가장 마지막에 온다는 것을 잊지말자

SELECT ai.NAME, ai.DATETIME
FROM ANIMAL_INS ai
LEFT JOIN ANIMAL_OUTS ao
ON ai.ANIMAL_ID = ao.ANIMAL_ID
WHERE ao.DATETIME IS NULL
ORDER BY ai.DATETIME ASC
LIMIT 3;
