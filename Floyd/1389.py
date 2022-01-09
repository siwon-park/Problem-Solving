#케빈 베이컨의 6단계 법칙(1389번)
##########################################################
    # 문제: https://www.acmicpc.net/problem/1389
    # 플로이드-워셜 알고리즘
##########################################################
import sys
input=sys.stdin.readline
INF=sys.maxsize
N,M=map(int,input().split())
board=[[INF]*(N+1) for i in range(N+1)]
for i in range(1,N+1):
    board[i][i]=0
for i in range(M):
    A,B=map(int,input().split())
    board[A][B],board[B][A]=1,1

for k in range(1,N+1):
    for a in range(1,N+1):
        for b in range(1,N+1):
            cost=board[a][k]+board[k][b]
            if cost<board[a][b]:
                board[a][b]=cost

min_kb=sys.maxsize
for i in range(1,N+1):
    board[i][0]=sum(board[i][1:])
    if board[i][0]<min_kb:
        min_kb=board[i][0]
        num=i
print(num)        
