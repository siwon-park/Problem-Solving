-- 입양 시각 구하기(1)
-- 날짜 형식의 데이터에서 시간만 뽑아오는 방법 HOUR()
-- HAVING은 집계 함수에만 쓸 수 있음 => 원래 있는 테이블의 형태 변환의 경우에는 사용 불가능
-- WHERE HOUR(DATETIME) >= 9 와 WHERE HOUR(DATETIME) >=9 AND HOUR(DATETIME) <= 19은 다르다 => 데이터에 19:59를 넘어서는 데이터가 있는듯하다
SELECT HOUR(DATETIME) AS 'HOUR', COUNT(DATETIME) AS 'COUNT' FROM ANIMAL_OUTS WHERE HOUR(DATETIME) >=9 AND HOUR(DATETIME) <= 19 GROUP BY HOUR(DATETIME)ORDER BY HOUR(DATETIME) ASC;
