# 행운의 문자열(1342번)
##################################################################################################
    # 문제: https://www.acmicpc.net/problem/1342
    # 브루트포스(백트랙킹)
    # 백트랙킹을 통한 순열 + 가지치기로 문제를 접근했다
    # Pypy3로 통과, Python3으로는 시간초과 판정을 받았다
    # 풀이 자체는 썩 맘에 들지 않는다
    # 다른 사람들의 빠른 풀이를 보니 다양한 방식으로 백트랙킹을 구현하였다.
    # 나도 다양한 방식으로 백트랙킹을 풀 수 있도록 연습해야겠다
##################################################################################################
import sys
input = sys.stdin.readline

S = list(input().rstrip())

cnt = 0
N = len(S)

visited = [False] * N
s = set()

def dfs(k, lst):
    global cnt
    if k > 1 and lst[-1] == lst[-2]:
        return
    if k == N:
        ret = "".join(lst)
        if ret not in s:
            s.add(ret)
            cnt += 1
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            lst.append(S[i])
            dfs(k+1, lst)
            lst.pop()
            visited[i] = False

dfs(0, [])
print(cnt)
