-- 있었는데요 없었습니다
-- INNER JOIN을 사용하는 기본적인 JOIN 문제
SELECT ai.ANIMAL_ID, ai.NAME
FROM ANIMAL_INS ai
INNER JOIN ANIMAL_OUTS ao
ON ai.ANIMAL_ID = ao.ANIMAL_ID
WHERE ao.DATETIME < ai.DATETIME
ORDER BY ai.DATETIME ASC;
