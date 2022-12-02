-- 진료과별 총 예약 횟수 출력하기
-- 자꾸 틀렸습니다를 받아서 문제를 다시 읽어보니 '5월'에 해당하는 데이터를 group by로 묶어서 출력해야했다.
-- 애꿎은 where절에 예약 취소 여부가 'N'인 것만 뽑으려고 했다.
-- 5월을 뽑을 때 확인해보니 WHERE DATE_FORMAT(APNT_YMD, '%m') = '05'도 가능하고 WHERE DATE_FORMAT(APNT_YMD, '%m') = 5도 가능하다.
SELECT MCDP_CD AS '진료과코드', COUNT(PT_NO) AS '5월예약건수' FROM APPOINTMENT WHERE DATE_FORMAT(APNT_YMD, '%m') = '05' GROUP BY MCDP_CD ORDER BY COUNT(PT_NO) ASC, MCDP_CD ASC;
