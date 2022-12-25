-- 조건별로 분류하여 주문상태 출력하기
-- 조건에 따라 출력을 달리하기 위해 CASE-WHEN-THEN-ELSE-END 구문을 사용하였다.
-- 그런데 자꾸 syntax에러가 떠서 자세하게 봤더니 SELECT 구문에서 콤마(,)를 찍어주지 않고 있었다.
-- CASE 구문도 하나의 칼럼으로서 SELECT 구문을 통해 조건부로 조회하는 것이기 때문에
-- 칼럼을 구분하기 위해 앞에 칼럼이 끝나고 나서 CASE문을 쓰기 전에 콤마(,)가 필요하다.
-- 다른 사람들 풀이를 확인하니 지금까지 날짜를 비교해줄 때도 DATE_FORMAT으로 변환한 다음 비교해줬는데
-- 이 문제는 아마 시간이 전부 00:00:00으로 들어와서 그런지 그냥 OUT_DATE > '2022-05-01'로 비교해줘도 됐다.
-- 여담이지만, 문제에 2022년도 데이터라는 말이 필요할 것 같다는 생각이 든다.

SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
    CASE
    WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
    WHEN ISNULL(OUT_DATE) THEN '출고미정'
    ELSE '출고완료'
    END AS '출고여부'
FROM FOOD_ORDER
ORDER BY ORDER_ID;
