-- 과일로 만든 아이스크림 고르기
-- FIRST_HALF 테이블과 ICECREAM_INFO 테이블에 FLAVOR가 있으니 INNER JOIN을 사용했다.
-- Column in field list is ambiguous 에러가 자꾸 나서 확인해보니까
-- SELECT 쪽의 FLAVOR에도 어느쪽 테이블인지 명시해줘야 했었다.
SELECT f.FLAVOR FROM FIRST_HALF f INNER JOIN ICECREAM_INFO i ON f.FLAVOR = i.FLAVOR WHERE TOTAL_ORDER > 3000 AND i.INGREDIENT_TYPE = 'fruit_based';
