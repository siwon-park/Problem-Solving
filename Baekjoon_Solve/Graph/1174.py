# 줄어드는 수(1174번)
###########################################################
    # 문제: https://www.acmicpc.net/problem/1174
    # 백트랙킹
    # 실버2 정도 되는 문제라 생각했는데 풀고나니 골드5여서 조금 놀랐다.
    # 이 문제의 핵심은 내림차순 순열을 구할 수 있는가이다.
    # 0 ~ 9 각각 1자리수는 줄어드는 수라는 것을 명심해야한다.
    # 따라서 2자리 이상이 되었을 때, 뒷자리 수가 앞자리 수보다 크면 return하도록 가지치기를 하면 된다.
###########################################################
import sys
input = sys.stdin.readline

N = int(input())
visited = [False] * 10
ret = []

def dfs(k, num):
    if k >= 2:
        if num[-2] < num[-1]:
            return
    ret.append(int(num))
    if k == 10:
        return
    for i in range(10):
        if not visited[i]:
            visited[i] = True
            dfs(k+1, num+str(i))
            visited[i] = False

dfs(0, "0")
ret.sort()
if N >= len(ret):
    print(-1)
else:
    print(ret[N])
