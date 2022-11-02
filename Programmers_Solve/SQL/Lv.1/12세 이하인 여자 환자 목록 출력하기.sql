-- PATIENT 테이블에서 12세 이하인 여자환자의 환자이름, 환자번호, 성별코드, 나이, 전화번호를 조회하는 SQL문을 작성
-- 이때 전화번호가 없는 경우, 'NONE'으로 출력시켜 주시고 결과는 나이를 기준으로 내림차순 정렬하고, 나이 같다면 환자이름을 기준으로 오름차순 정렬
-- null 처리 방법 => IFNULL(칼럼명, 처리할 내용) AS 칼럼명 (칼럼명을 AS로 바꾸지 않으면 IFNUL...로 썼던 내용이 칼럼명이 된다.)
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') AS TLNO FROM PATIENT WHERE AGE <= 12 AND GEND_CD = 'W' ORDER BY AGE DESC, PT_NAME ASC;
