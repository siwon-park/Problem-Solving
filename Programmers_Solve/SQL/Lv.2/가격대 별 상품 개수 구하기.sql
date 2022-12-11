-- 가격대 별 상품 개수 구하기
-- 나누기 한 결과 몫을 구하고 싶을 때는 FLOOR를 사용해야하는 것을 알았다.
-- 나누기 한 몫을 기준으로 GROUP BY를 한 다음에 오름차순 정렬하면 된다.
SELECT FLOOR(PRICE / 10000) * 10000 AS PRICE_GROUP, COUNT(PRICE) AS PRODUCTS
FROM PRODUCT
GROUP BY FLOOR(PRICE / 10000)
ORDER BY FLOOR(PRICE / 10000) ASC;
