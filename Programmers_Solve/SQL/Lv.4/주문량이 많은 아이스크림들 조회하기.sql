-- 주문량이 많은 아이스크림들 조회하기
-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.

SELECT fh.FLAVOR
FROM FIRST_HALF fh
INNER JOIN (SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
            FROM JULY
            GROUP BY FLAVOR) j
ON fh.FLAVOR = j.FLAVOR
ORDER BY fh.TOTAL_ORDER + j.TOTAL_ORDER DESC
LIMIT 3;
