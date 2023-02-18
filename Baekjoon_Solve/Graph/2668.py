# 숫자고르기(2668번)
##############################################################################
    # 문제: https://www.acmicpc.net/problem/2668
    # DFS
    # 어떻게 접근해야할지 감이 안왔었는데, 다른 사람 풀이를 보고서 힌트를 얻을 수 있었다.
    # 이 문제를 그래프로 접근하여 사이클이 발생했을 경우에만 ret에 그 원소를 append하는 것이다.
    # 사이클이 발생했다는 것은 서로가 서로를 참조하고 있다는 의미가 되므로,
    # 사이클인 요소들을 최대한 모두 뽑으면 픽한 번호의 개수가 픽한 번호 안의 조합과 일치하게 된다.
    # DFS연습이 더 필요하다...
##############################################################################
import sys
input = sys.stdin.readline

N = int(input())
arr = [0] * (N+1)
for i in range(1, N+1):
    arr[i] = int(input())
ret = []

def dfs(cur, i):
    visited[cur] = True
    if not visited[arr[cur]]:
        dfs(arr[cur], i)
    elif visited[arr[cur]] and arr[cur] == i:
        ret.append(arr[cur])

for i in range(1, N+1):
    visited = [False]*(N+1)
    dfs(i, i)
    
print(len(ret))
for i in range(len(ret)):
    print(ret[i])
