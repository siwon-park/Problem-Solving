# 색칠하기(13265번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/13265
    # BFS
    # 문제 자체는 어려운 문제가 아니나, 80% 근처에서 틀렸습니다 판정을 받았다.
    # 그 이유를 질문 게시판을 통해서 찾아보니 문제에서 주어지는 모든 노드가 항상 연결 컴포넌트이룬다는 조건이 없다는 것이다.
    # 나중에 풀이를 적으면서 문제를 읽어 보았는데, 문제 조건에도 주어져 있었다 => (모든 동그라미들 사이에 직선이 있을 필요는 없다)
    # 따라서 그 점만 유의해서 풀면 크게 막히는 부분은 없을 것이다.
    # 코드 풀이는 주석 참고
###################################################################################
import sys
from collections import deque
input = sys.stdin.readline

def bfs(s):
    visited[s] = 1 # 1번 색을 s번 노드에 칠함
    q = deque([(2, s)]) # 다음 칠할 색인 2번을 s번 노드와 함께 넣고 bfs를 돌림
    while q:
        clr, cur = q.popleft() # 칠할 색, 현재 좌표
        for nxt in graph[cur]:
            if not visited[nxt]:
                visited[nxt] = clr
                if clr == 1:
                    q.append((2, nxt))
                else:
                    q.append((1, nxt))
            elif visited[nxt] == visited[cur]: # 다음 방문할 곳이 현재 칠해진 색과 같다면 False
                return False
    return True
    
T = int(input())
for tc in range(T):
    n, m = map(int, input().split())
    graph = [[] for _ in range(n + 1)]
    visited = [False] * (n + 1)

    for _ in range(m):
        x, y = map(int, input().split())
        graph[x].append(y)
        graph[y].append(x)
    
    flag = True
    for i in range(1, n + 1): # 연결 그래프가 아닐 수도 있으니 n번째까지 탐색함
        if not visited[i]:
            flag = bfs(i)
            if not flag:
                break
    
    if flag:
        print('possible')
    else:
        print('impossible')
