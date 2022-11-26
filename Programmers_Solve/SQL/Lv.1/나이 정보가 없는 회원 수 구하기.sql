-- 나이 정보가 없는 회원 수 구하기
-- null인지 판별하려면 is를 사용해야한다.
SELECT COUNT(USER_ID) AS USERS FROM USER_INFO WHERE AGE is NULL;
