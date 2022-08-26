-- 동명 동물 수를 찾되, 수가 1 이상인 동물의 이름을 COUNT와 같이 출력
-- HAVING을 언제 쓰는지 궁금했었는데, COUNT와 같은 집계함수를 WHERE절에서는 쓸 수 없어서, HAVING을 통해 쓴다는 것을 알게되었다.
-- GROUP BY절을 이용하여 그룹 당 하나의 결과로 그룹화 할 수 있다.
-- HAVING절을 사용하여 집계함수를 이용한 조건 비교를 할 수 있다.(GROUP BY 다음에 HAVING이 온다)
SELECT NAME, COUNT(*) AS 'COUNT' FROM ANIMAL_INS WHERE NAME IS NOT NULL GROUP BY NAME HAVING COUNT(*) > 1 ORDER BY NAME ASC;
