#돌다리(12761번)
######################################################
  # 문제: https://www.acmicpc.net/problem/12761
  # BFS
  # 좌표를 계산하는데 있어 실수함. 좌우 1칸(+-1) 좌우A,B칸(+-A,B), A배,B배 총 8가지였음(처음에 4가지, 6가지만 고려하였음)
######################################################
import sys
from collections import deque
input=sys.stdin.readline
A,B,N,M=map(int,input().split())
q=deque([(0,N)])
INF=sys.maxsize
visited=[INF]*100001
visited[N]=True
max_cnt=INF
while q:
    cnt,cur=q.popleft()
    if cur==M:
        max_cnt=min(max_cnt,cnt)
    lst=[cur-1,cur+1,cur+A,cur-A,cur+B,cur-B,cur*A,cur*B]
    for num in lst:
        if 0<=num<=100000:
            if cnt+1<visited[num]:
                q.append((cnt+1,num))
                visited[num]=cnt+1   
print(max_cnt)
