-- 상품 별 오프라인 매출 구하기
-- 잔실수 때문에 맞왜틀을 여러 번 했다.
-- SUM을 해서 판매량의 합을 구해서 곱해야했는데, COUNT를 사용해서 칼럼 갯수를 곱해주고 있었다.

SELECT p.PRODUCT_CODE, (SUM(os.SALES_AMOUNT) * p.PRICE) AS SALES
FROM PRODUCT p
INNER JOIN OFFLINE_SALE os
ON p.PRODUCT_ID = os.PRODUCT_ID
GROUP BY p.PRODUCT_CODE
ORDER BY SALES DESC, p.PRODUCT_CODE ASC;
