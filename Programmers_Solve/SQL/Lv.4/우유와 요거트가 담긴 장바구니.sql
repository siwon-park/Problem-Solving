-- 우유와 요거트가 담긴 장바구니
-- 문제 자체는 어렵지 않았는데, 디버깅 과정에서 self join을 했는데 칼럼의 중복이 발생한 것을 확인할 수 있었다.
-- 조건에 맞는 데이터가 전부 다 중복이 생겼으면 그러려니 하겠는데,
-- 일부는 생기고, 일부는 생기지 않아서 원인을 잘 모르겠다...

SELECT cp1.CART_ID
FROM CART_PRODUCTS cp1
INNER JOIN (SELECT CART_ID, NAME AS MILK
           FROM CART_PRODUCTS
            WHERE NAME = 'Milk'
           ) cp2
ON cp1.CART_ID = cp2.CART_ID
WHERE cp1.NAME = 'Yogurt'
GROUP BY cp1.CART_ID
ORDER BY cp1.CART_ID ASC;
