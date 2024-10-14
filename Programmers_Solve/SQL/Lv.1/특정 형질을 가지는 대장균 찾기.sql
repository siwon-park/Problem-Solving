-- 특정 형질을 가지는 대장균 찾기
-- 2번 형질을 가지지 않으려면 2번과 비트 AND 연산 시 결과가 0이어야 하며
-- 1, 3번 형질을 가지려면 5번과 비트 AND 연산을 했을 때 결과가 0이 아니면 됨
SELECT COUNT(*) AS 'COUNT'
FROM ecoli_data
WHERE (2 & genotype = 0) AND (5 & genotype != 0);
