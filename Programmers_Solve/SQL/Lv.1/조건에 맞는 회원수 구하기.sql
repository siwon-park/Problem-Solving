-- 조건에 맞는 회원 수 구하기
-- 회원 수를 구해야하므로 COUNT를 사용하였음
-- 21년도에 가입한 회원을 찾아야 하므로 DATE_FORMAT을 사용하여 가입년도가 2021인 회원 리스트에서 USER_ID를 COUNT하는 방식을 적용하였다. 
SELECT COUNT(USER_ID) AS USERS FROM USER_INFO WHERE DATE_FORMAT(JOINED, '%Y') = 2021 AND 20 <= AGE AND AGE <= 29;
