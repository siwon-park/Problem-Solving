# 내려가기(2096번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/2096
    # DP
    # 평범한 DP 문제이지만, 메모리 사용량이 4MB이므로 DP배열을 만들어서 모든 배열에 결과값을 저장하는 방식으로 푸는 게 아니고
    # 바로 직전 값만 저장하는 방식으로 해결하면 된다.
###################################################################################
import sys
input = sys.stdin.readline

N = int(input())
n = 1
for i in range(N):
    t1, t2, t3 = map(int, input().split())
    if n == 1:
        d1, d2, d3 = [t1, t1], [t2, t2], [t3, t3]
        max_v, min_v = max(t1, t2, t3), min(t1, t2, t3)
    else:
        max_d1, min_d1 = max(d1[0], d2[0]) + t1, min(d1[1], d2[1]) + t1
        max_d2, min_d2 = max(d1[0], d2[0], d3[0]) + t2, min(d1[1], d2[1], d3[1]) + t2
        max_d3, min_d3 = max(d2[0], d3[0]) + t3, min(d2[1], d3[1]) + t3
        d1, d2, d3 = [max_d1, min_d1], [max_d2, min_d2], [max_d3, min_d3]
        max_v, min_v = max(max_d1, max_d2, max_d3), min(min_d1, min_d2, min_d3)
    n += 1
print(max_v, min_v)
