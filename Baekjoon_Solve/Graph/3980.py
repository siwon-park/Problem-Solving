# 선발명단(3980번)
###################################################################
    # 문제: https://www.acmicpc.net/problem/3980
    # 백트랙킹
    # 처음 풀었을 때, 엄청 오래 걸려서 도중에 중지시키고 가지치기를 해야하나 싶었는데
    # 최대합을 구하는 것이라 가지치기를 하기 쉽지 않았고 어떻게 해야하지 고민하던 찰나에 문제를 다시 읽어보니
    # 0은 그 선수가 그 포지션에 적합하지 않다는 뜻이고, 각 선수는 능력치가 0인 포지션에 배치될 수 없다고 했으므로
    # 순열을 구성할 때 해당 포지션에서 능력치가 0이 아닐 경우에 뽑는 방향으로 코드를 짜니 가지치기 없이도 해결되었다.
###################################################################
import sys
input = sys.stdin.readline

def dfs(k, potent):
    global max_potent
    if k == 11:
        if potent > max_potent:
            max_potent = potent
        return
    for i in range(11):
        if not visited[i] and line_up[k][i] != 0:
            visited[i] = True
            dfs(k+1, potent+line_up[k][i])
            visited[i] = False

C = int(input())
for c in range(C):
    line_up = [list(map(int, input().split())) for _ in range(11)]
    max_potent = 0
    visited = [False]*11
    dfs(0, 0)
    print(max_potent)
