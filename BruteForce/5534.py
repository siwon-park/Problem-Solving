# 간판(5534번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/5534
    # 문자열, 브루트포스
    # 백트랙킹으로 브루트포스를 구현하여 풀었다.
    # 백트랙킹을 사용한 이유는
    # 맨 처음엔 그냥 for구문으로 풀려했는데, 보니까 분기점을 고려해야해서 for구문으로 구현하는 것보다
    # 백트랙킹을 통해 구현하는 게 더 낫겠다 싶어서 그렇게 하였다.
    # 한 실버 2정도 되는 문제겠거니 했는데, 실버 5였다. 아마 브루트포스로 고려하는 것 빼곤 크게 문제되는 부분이 없어서 그런듯하다.
########################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

# 백트랙킹
def dfs(k, s, l, lst):
    global flag
    if len(set(lst)) > 1 or flag:
        return
    if k == n or l == M:
        flag = True
        return
    for i in range(s, n):
        if not visited[i] and string[i] == S[l]:
            visited[i] = True
            lst.append(i - s)
            dfs(k + 1, i, l + 1, lst)
            visited[i] = False
            lst.pop()

N = int(input())
S = input().rstrip()
M = len(S)
cnt = 0
for _ in range(N):
    string = input().rstrip()
    n = len(string)
    visited = [False] * n
    flag = False
    for j in range(n):
        if string[j] == S[0]:
            dfs(0, j, 1, [])
            if flag:
                cnt += 1
                break

print(cnt)
