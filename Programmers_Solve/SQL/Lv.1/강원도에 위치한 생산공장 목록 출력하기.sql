-- 강원도에 위치한 생산공장 목록 출력하기
-- ADDRESS가 강원도로 시작하는 데이터를 찾기 위해 WHERE LIKE 구문을 사용하였다.
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS FROM FOOD_FACTORY WHERE ADDRESS LIKE '강원도%';
