-- 보호소에서 중성화한 동물
-- INNER JOIN과 IN을 사용해서 풀었다.
-- 처음에 SEX_UPON_OUTCOME도 2개의 LIKE 절을 사용했는데, IN절을 사용하는 것이 더 간결하다.

SELECT ai.ANIMAL_ID, ai.ANIMAL_TYPE, ai.NAME
FROM ANIMAL_INS ai
INNER JOIN ANIMAL_OUTS ao
ON ai.ANIMAL_ID = ao.ANIMAL_ID
WHERE ai.SEX_UPON_INTAKE LIKE 'Intact%' AND ao.SEX_UPON_OUTCOME IN ('Spayed Female', 'Neutered Male')
ORDER BY ai.ANIMAL_ID ASC;
