-- 조건에 맞는 도서와 저자 리스트 출력하기
-- INNER JOIN을 사용하는 문제. 처음으로 SQL 문제를 원큐에 맞췄다.
-- 카테고리가 '경제'이고, 출판일을 기준으로 오름차순 정렬해야함을 유의
SELECT b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK b
INNER JOIN AUTHOR a
ON b.AUTHOR_ID = a.AUTHOR_ID
WHERE b.CATEGORY = '경제'
ORDER BY b.PUBLISHED_DATE ASC;
