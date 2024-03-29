-- 서울에 위치한 식당 목록 출력하기
SELECT ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS, rr.SCORE
FROM REST_INFO ri
INNER JOIN (SELECT REST_ID, ROUND(AVG(REVIEW_SCORE), 2) AS SCORE
            FROM REST_REVIEW
            GROUP BY REST_ID) rr
ON ri.REST_ID = rr.REST_ID
WHERE ri.ADDRESS LIKE '서울%'
ORDER BY rr.SCORE DESC, ri.FAVORITES DESC;
