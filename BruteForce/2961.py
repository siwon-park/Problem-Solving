# 도영이가 만든 맛있는 음식(2961번)
####################################################################
    # 문제: https://www.acmicpc.net/problem/2961
    # 브루트포스 알고리즘
    # 부분집합을 구하면서 신맛과 쓴맛의 차이의 최솟값을 출력하면 된다.
    # dfs로 구현하였고, 부분집합이므로 1개를 골라도 되므로 최솟값을 매번 갱신시켜줘야한다. 
####################################################################
import sys
input = sys.stdin.readline

def dfs(s, t1, t2):
    global min_taste
    if t1 > 0 and t2 > 0:
        if min_taste > abs(t1 - t2):
            min_taste = abs(t1 - t2)
    if s == N:
        return
    for i in range(s, N):
        dfs(i+1, t1*foods[i][0], t2+foods[i][1])

N = int(input())
foods = [tuple(map(int, input().split())) for _ in range(N)]
min_taste = sys.maxsize
dfs(0, 1, 0)
print(min_taste)
