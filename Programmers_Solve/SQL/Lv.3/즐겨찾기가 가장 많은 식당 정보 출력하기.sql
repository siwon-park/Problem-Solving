-- 즐겨찾기가 가장 많은 식당 정보 출력하기
-- 서브쿼리와 join을 사용하는 문제
-- 서브쿼리로 FOOD_TYPE을 그룹화한 새로운 테이블을 만들고 해당 테이블을 JOIN하여 sql구문을 짜는 문제였다.

SELECT r1.FOOD_TYPE, r1.REST_ID, r1.REST_NAME, r1.FAVORITES
FROM REST_INFO r1
INNER JOIN (SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES
           FROM REST_INFO
           GROUP BY FOOD_TYPE) r2
ON r1.FOOD_TYPE = r2.FOOD_TYPE AND r1.FAVORITES = r2.FAVORITES
ORDER BY r1.FOOD_TYPE DESC;
