-- 자동차 평균 대여 기간 구하기
-- 실수한 점: 전체 대여 기간에서 자동차 ID가 등장한 수로 나누는 방식으로 평균을 구하고 있었다.
-- 현재 날짜를 포함해서 계산해야 하므로 +1을 해주는 것을 주의해야 한다.
SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1) ,1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC;