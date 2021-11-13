#스타트와 링크(14889번)
##########################################
    # 문제: https://www.acmicpc.net/problem/14889
    # 조합, 브루트포스 알고리즘
    # 시간이 6508m/s 걸려서 개선이 필요함
##########################################
import sys
from itertools import combinations
input=sys.stdin.readline
N=int(input())
board=[]
for i in range(N):
    board.append(list(map(int,input().split())))
result=[]
team=[i for i in range(N)]
s=set(team)
min_diff=int(1e9)
for start in combinations(team,N//2):
    link=list(s-set(start))
    sum_start,sum_link=0,0
    for i in range(N//2):
        for j in range(i+1,N//2):
            sum_start+=(board[start[i]][start[j]]+board[start[j]][start[i]])
            sum_link+=(board[link[i]][link[j]]+board[link[j]][link[i]])
    if abs(sum_start-sum_link)<min_diff:
        min_diff=abs(sum_start-sum_link)
print(min_diff)
