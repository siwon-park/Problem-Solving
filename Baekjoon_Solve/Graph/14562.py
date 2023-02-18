# 태권왕(14562번)
#########################################################################################
    # 문제: https://www.acmicpc.net/problem/14562
    # BFS
    # 간단한 BFS문제, cur > target이면 영원히 cur == target인 순간은 오지 않으므로, cur < target일 때만 큐에 삽입한다
#########################################################################################
import sys
from collections import deque
input = sys.stdin.readline

def bfs(s, t):
    q = deque([(0, s, t)]) # 횟수, 현재 위치
    while q:
        cnt, cur, target = q.popleft()
        if cur == target:
            return cnt

        if cur < target: # cur > target이면 영원히 cur == target인 순간은 오지 않음
            q.append((cnt + 1, cur + cur, target + 3)) # 연속 발차기 A
            q.append((cnt + 1, cur + 1, target)) # 연속 발차기 B

C = int(input())
for _ in range(C):
    S, T = map(int, input().split())
    print(bfs(S, T))
