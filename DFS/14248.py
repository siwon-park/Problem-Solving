# 점프 점프(14248번)
#############################################################
    # 문제: https://www.acmicpc.net/problem/14248
    # BFS, DFS
    # BFS로 풀었던 문제를 DFS로도 구현해보았음
    # 구현 로직 자체 및 코드 자체는 개인적으로 DFS가 더 깔끔해보인다.
    # 속도는 사실상 유의미한 차이가 없음 DFS가 8ms더 빠른데 백준에서 함수 호출해서 문제 푸는게 속도가 더 빠르다는 걸 감안해도 속도차이는 매우 미미함
#############################################################
import sys
input = sys.stdin.readline

def dfs(cur):
    global cnt
    visited[cur] = True
    cnt += 1
    jump = stones[cur-1]
    if 0 < cur - jump <= N and not visited[cur - jump]:
        dfs(cur - jump)
    if 0 < cur + jump <= N and not visited[cur + jump]:
        dfs(cur + jump)

N = int(input())
stones = list(map(int, input().split()))
s = int(input())

visited = [False]*(N+1)
cnt = 0

dfs(s)
print(cnt)
