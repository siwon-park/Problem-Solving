-- 카테고리 별 도서 판매량 집계하기
-- JOIN문과 GROUP BY를 사용해서 카테고리별로 특정 년월의 도서 판매량을 출력하는 문제
-- WHERE절은 GROUP BY 앞에 써야한다.

SELECT b.CATEGORY, SUM(bs.SALES) AS TOTAL_SALES
FROM BOOK b
INNER JOIN BOOK_SALES bs
on b.BOOK_ID = bs.BOOK_ID
WHERE DATE_FORMAT(bs.SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY b.CATEGORY
ORDER BY b.CATEGORY ASC;
