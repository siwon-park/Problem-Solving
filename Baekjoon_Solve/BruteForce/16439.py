# 치킨치킨치킨(16439번)
###########################################################################
    # 문제: https://www.acmicpc.net/problem/16439
    # 브루트포스
    # 처음에 DFS, 백트랙킹으로 모든 경우를 완전탐색하는 방법으로 구현을 하니까 시간초과 판정을 받았다.
    # 그 후에 잠깐 생각을 해보니 굳이 완전탐색을 할 필요가 없었다. 3가지를 픽하는 중복 조합 셋을 구한 뒤에
    # 해당 각 사람별로 해당 3가지 픽 중 가장 큰 만족도를 갖는 값을 택해서 더하고, 더한 결과값을 최댓값과 비교하여 갱신하는 방법으로 해결하면 된다.
    # 중복조합을 구하는 것은 DFS로 구현하였다.
###########################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, M = map(int, input().split())
priority = [list(map(int, input().split())) for _ in range(N)]
comb_lst = []

def dfs(k, s, lst):
    if k == 3:
        comb_lst.append(lst[:])
        return
    for i in range(s, M):
        dfs(k+1, i, lst+[i])

dfs(0, 0, [])

max_sum = 0
for comb in comb_lst:
    p1, p2, p3 = comb
    tmp_sum = 0
    for lst in priority:
        tmp_sum += max(lst[p1], lst[p2], lst[p3])
    max_sum = max(max_sum, tmp_sum)
print(max_sum)
