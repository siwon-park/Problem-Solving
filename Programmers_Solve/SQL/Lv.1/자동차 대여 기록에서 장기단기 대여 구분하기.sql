-- 자동차 대여 기록에서 장기단기 대여 구분하기
-- 이게 어떻게 레벨 1인지 모르겠다...
-- DATEDIFF는 단순히 차이를 구하는 것이기 때문에 시작일 기준으로 30일 이상이면 차이 값에 + 1을 해줘야한다.(시작일을 포함하기 위함)

SELECT HISTORY_ID, CAR_ID,
DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,
DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
CASE
    WHEN DATEDIFF(END_DATE, START_DATE) >= 29 THEN '장기 대여'
    ELSE '단기 대여'
END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE MONTH(START_DATE) = 9 AND YEAR(START_DATE) = 2022
ORDER BY HISTORY_ID DESC;
