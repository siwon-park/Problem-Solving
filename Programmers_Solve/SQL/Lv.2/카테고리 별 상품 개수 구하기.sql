-- 카테고리 별 상품 개수 구하기
-- 부분 문자열을 추출하기 위한 함수는 SUBSTR이다. 인덱스는 여느 프로그래밍 언어처럼 0으로 시작하지 않고 1부터 시작함을 유의!
SELECT SUBSTR(PRODUCT_CODE, 1, 2) AS CATEGORY, COUNT(PRODUCT_ID) AS PRODUCTS
FROM PRODUCT
GROUP BY SUBSTR(PRODUCT_CODE, 1, 2)
ORDER BY PRODUCT_CODE ASC;
