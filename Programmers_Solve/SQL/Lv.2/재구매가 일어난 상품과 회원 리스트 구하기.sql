-- 재구매가 일어난 상품과 회원 리스트 구하기
-- 재구매라고 해서 왠지 회원 아이디와 제품 아이디가 2번 이상 등장하면 되는 것이라고 생각했다
-- 그래서 처음에 WHERE절을 사용하려고 봤더니 WHERE절은 COUNT와 같은 구문을 사용 못한다.
-- 찾아보니, HAVING을 쓰면 된다는 것을 알았고, HAVING은 GROUP BY를 같이 써야한다.
-- 그런데 GROUP BY를 처음 쓸 때, 튜플처럼 묶으려고 하니까 오류가 났다. 그래서 이게 아닌가 싶었는데,
-- 알고보니 GROUP BY는 튜플처럼 묶어서 쓰는 것이 아니라 그냥 열거형으로 써도 됐다.
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(PRODUCT_ID) >= 2
ORDER BY USER_ID ASC, PRODUCT_ID DESC;
