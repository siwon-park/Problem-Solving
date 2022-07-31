# 도전 숫자왕(23057번)
#####################################################################
    # 문제: https://www.acmicpc.net/problem/23057
    # 브루트포스, 조합
    # lst의 요소에서 각 요소의 합 조합을 만들면서 집합에 추가시키고
    # lst의 모든 요소의 합에서 집합의 갯수를 뺀 다음 + 1을 해주면 된다.
    # 1을 더해주는 이유는 집합에 0이 들어있어 이를 빼줬기 때문에 다시 더해줘야한다.
#####################################################################
import sys
input = sys.stdin.readline

N = int(input())
lst = list(map(int, input().split()))
M = sum(lst)
num_set = set(lst)

def dfs(k, s, total):
    num_set.add(total)
    if k == N:
        return
    for i in range(s, N):
        dfs(k + 1, i + 1, total + lst[i])

dfs(0, 0, 0)
print(M - len(num_set) + 1)
