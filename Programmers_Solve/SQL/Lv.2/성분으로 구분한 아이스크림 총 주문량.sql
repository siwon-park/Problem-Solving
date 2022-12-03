-- 성분으로 구분한 아이스크림 총 주문량
-- inner join을 사용하였다. 또한 성분 종류로 group by를 하면서 TOTAL_ORDER에 대한 합을 구해야하므로 SUM을 사용하였다.
SELECT ii.INGREDIENT_TYPE, SUM(fh.TOTAL_ORDER) AS TOTAL_ORDER FROM FIRST_HALF fh INNER JOIN ICECREAM_INFO ii on fh.FLAVOR = ii.FLAVOR GROUP BY ii.INGREDIENT_TYPE;
