# 게으른 백곰(10025번)
####################################################################################
    # 문제: https://www.acmicpc.net/problem/10025
    # 투 포인터, 슬라이딩 윈도우
    # 2 중 for문으로 돌리면 O(n^2)으로 시간초과가 난다
    # 따라서 투 포인터, 슬라이딩 윈도우 기법으로 풀면 O(N)의 시간으로 해결할 수 있다.
####################################################################################
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
MAX = int(1e6)
lst = [0] * (MAX + 1)
max_x = -1
cur_sum = 0
for _ in range(N):
    g, x = map(int, input().split())
    lst[x] = g
    max_x = max(max_x, x)
    cur_sum += g

def find_max_sum():
    if 2 * K >= max_x:
        return cur_sum

    start, end = 0, 2 * K
    max_sum = sum(lst[:end + 1])
    cur = max_sum
    while end + 1 <= max_x:
        end += 1
        cur = cur + lst[end] - lst[start]
        start += 1
        max_sum = max(max_sum, cur)
    return max_sum

print(find_max_sum())
