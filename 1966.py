# 프린터 큐(1966번)
#######################################################
    # 문제: https://www.acmicpc.net/problem/1966
    # 큐, 구현
    # 2개의 큐를 사용해서 구현했다. 1개는 우선순위만 담은 큐이고, 다른 한개는 (우선순위, 인덱스) 튜플을 담은 큐이다.
    # 두 큐에서 원소를 빼서, 우선 순위가 같을 경우 order+=1을 해줬다. 이때, 인덱스가 M과 같다면 order를 print하고 break하였다.
    # 구현 순서 및 동작원리만 잘 짜면 되는 문제
    # collections패키지의 deque모듈을 쓰지 않고 front와 rear을 활용해 쉽게 구현하는 방법도 사용해봐야겠다. 스택으로도 구현한 사람이 있었다.
#######################################################
import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
for t in range(1, T+1):
    N, M = map(int, input().split())
    priority = list(map(int, input().split()))
    if N == 1:
        print(1)
        continue
    q1 = deque()
    for i, p in enumerate(priority):
        q1.append((p, i))

    priority.sort(key = lambda x: -x)
    q2 = deque(priority)
    order = 1
    while True:
        p1, indx = q1.popleft()
        p2 = q2.popleft()
        if p1 == p2:
            if indx == M:
                print(order)
                break
            order += 1
        else:
            q1.append((p1, indx))
            q2.appendleft(p2)
