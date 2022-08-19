-- 동물 보호소에 가장 먼저 들어온 동물의 이름을 조회
-- LIMIT number; 출력할 행을 제한
-- OFFSET number; 출력할 행의 시작점
-- LIMIT 1 OFFSET 0; => 가장 상위에 있는 행 한 개를 출력해라
SELECT NAME FROM ANIMAL_INS ORDER BY DATETIME ASC LIMIT 1 OFFSET 0;
