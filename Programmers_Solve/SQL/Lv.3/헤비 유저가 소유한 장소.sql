-- 헤비 유저가 소유한 장소
-- self join을 사용하는 것이 포인트이다.

SELECT p1.ID, p1.NAME, p1.HOST_ID
FROM PLACES p1
INNER JOIN (SELECT HOST_ID, COUNT(HOST_ID) AS COUNT_HOST
           FROM PLACES
           GROUP BY HOST_ID) p2
ON p1.HOST_ID = p2.HOST_ID
WHERE p2.COUNT_HOST >= 2
ORDER BY ID ASC;
