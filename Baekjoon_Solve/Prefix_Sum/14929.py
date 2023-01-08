# 귀찮아 (SIB) (14929번)
"""
  문제: https://www.acmicpc.net/problem/14929
  누적합
  순서쌍 곱의 합(13900번)과 같은 유형의 문제
  여담이지만, 수학적으로 푼 사람과 숏코딩으로 푼 사람들 코드를 봤는데 대단하다는 말밖에 안 나온다...
"""
import sys
input = sys.stdin.readline

N = int(input().rstrip())
x = list(map(int, input().rstrip().split()))
prefix_sum = [0] * (N + 1)

for i in range(1, N + 1):
    prefix_sum[i] = prefix_sum[i - 1] + x[i - 1]

ans = 0
for i in range(2, N + 1):
    ans += prefix_sum[i - 1] * x[i - 1]

print(ans)
