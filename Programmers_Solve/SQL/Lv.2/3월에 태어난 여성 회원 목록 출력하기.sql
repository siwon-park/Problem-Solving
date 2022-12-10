-- 3월에 태어난 여성 회원 목록 출력하기
-- 왜 자꾸 DATE_FORMAT을 DATETIME으로 기억하는지 모르겠다... 그리고 포멧팅 형식도 아직도 헷갈린다.
-- 문제를 자꾸 틀려서 다른 사람이 올려놓은 정답을 봤더니 GENDER = 'W'인 회원을 뽑아와야 했는데, 전부 다 뽑아오는 실수를 하고 있었다. 문제를 제대로 안 읽은 결과다...
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH FROM MEMBER_PROFILE WHERE TLNO IS NOT NULL AND DATE_FORMAT(DATE_OF_BIRTH, '%m') = 3 AND GENDER = 'W' ORDER BY MEMBER_ID ASC;
