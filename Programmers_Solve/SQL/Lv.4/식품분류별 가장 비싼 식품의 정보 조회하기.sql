-- 식품분류별 가장 비싼 식품의 정보 조회하기
-- 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회하는 SQL문을 작성
-- 이때 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력시켜 주시고 결과는 식품 가격을 기준으로 내림차순 정렬

SELECT fd1.CATEGORY, fd1.PRICE, fd1.PRODUCT_NAME
FROM FOOD_PRODUCT fd1
INNER JOIN (SELECT CATEGORY, MAX(PRICE) AS PRICE
           FROM FOOD_PRODUCT
           GROUP BY CATEGORY
            HAVING CATEGORY IN ('과자', '국', '김치', '식용유')) fd2
ON fd1.CATEGORY = fd2.CATEGORY AND fd1.PRICE = fd2.PRICE
ORDER BY fd1.PRICE DESC;
