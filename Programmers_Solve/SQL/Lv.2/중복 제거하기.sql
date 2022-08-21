-- 동물 보호소에 들어온 동물의 이름은 몇 개인지 조회하는 SQL 문을 작성해주세요. 이때 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나로 칩니다.
-- 쿼리문에 익숙치 않은 내게 조금 어려운 문제였다.
-- 계속해서 GROUP BY를 썼는데 틀려서 뭐가 문제인지 정말 헤맸다. 중복이 없는 이름의 '총' 개수를 세는 것이므로, GROUP BY를 쓰면 안 됐다.
-- NULL 값인지 아닌지를 조회하려면 IS NULL, IS NOT NULL을 써야했다는 것을 알게 되었다.
-- DISTINCT를 통해서 중복을 제거하려 했는데, COUNT문 안에 DISTINCT를 써도 된다는 것을 알게 되었다. 

SELECT COUNT(DISTINCT NAME) AS 'count' FROM ANIMAL_INS WHERE NAME IS NOT NULL;
