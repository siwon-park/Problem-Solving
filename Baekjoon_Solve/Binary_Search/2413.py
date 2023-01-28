# 두 배열의 합 (2143번)
"""
  문제: https://www.acmicpc.net/problem/2143
  이분탐색, 누적합
  수열 A와 B에 대해서 가능한 모든 누적합 경우를 배열에 저장한다.
  n, m이 모두 1000이하이므로 완전탐색을 해도 시간상 충분하다.
  B의 누적합 배열만 정렬한다.(A의 누적합을 정렬하고, B의 누적합을 순회해도 됨)
  그 후, A의 누적합 배열을 순회하면서
  lowerbound, upperbound 탐색으로 T - A의 누적합이 B의 누적합에 위치한 가장 왼쪽 인덱스(lb)와 가장 오른쪽 인덱스(ub)를 찾는다.
  lb가 B의 누적합 배열의 길이 미만이면서, B의 누적합[lb] + A의 누적합 == T이고, B의 누적합[ub-1] + A의 누적합 == T이면 ub - lb를 누적한다.
  누적한 결과를 출력한다.
"""
import sys
from bisect import bisect_left, bisect_right
input = sys.stdin.readline

T = int(input().rstrip())
N = int(input().rstrip())
A = list(map(int, input().rstrip().split()))
M = int(input().rstrip())
B = list(map(int, input().rstrip().split()))

# 수열 A, B에 대해 가능한 모든 누적합 경우를 구함
A_sum, B_sum = [], []
for i in range(N):
    _sum = A[i]
    A_sum.append(_sum)
    for j in range(i + 1, N):
        _sum += A[j]
        A_sum.append(_sum)

for i in range(M):
    _sum = B[i]
    B_sum.append(_sum)
    for j in range(i + 1, M):
        _sum += B[j]
        B_sum.append(_sum)

# 정렬(이분 탐색을 위해 하나만 정렬)
B_sum.sort()

# lowerbound, uppperbound 탐색으로 T - A의 누적합이 B의 합에 있는지 찾음
ans = 0
K = len(A_sum)
O = len(B_sum)
for i in range(K):
    _sum = A_sum[i]
    lb = bisect_left(B_sum, T - _sum)
    ub = bisect_right(B_sum, T - _sum)
    if lb < O and _sum + B_sum[lb] == T and _sum + B_sum[ub - 1] == T:
        ans += ub - lb

print(ans)
