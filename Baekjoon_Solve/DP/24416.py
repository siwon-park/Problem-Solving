# 알고리즘 수업 - 피보나치 수 1 (24416번)
import sys
input = sys.stdin.readline

n = int(input().rstrip())
fibo = [0] * (n + 1)
func_cnt = 0  # 코드 2 실행 횟수

fibo[1], fibo[2] = 1, 1
for i in range(3, n + 1):
    fibo[i] = fibo[i - 1] + fibo[i - 2]
    func_cnt += 1

print(fibo[n], func_cnt)
