# 연산자 끼워넣기(2)(15658번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/15658
    # 백트랙킹
    # 연산자 끼워넣기(14888번)과 같은 문제
###############################################################################
import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
count = list(map(int, input().split()))

min_value = sys.maxsize
max_value = -sys.maxsize

def dfs(k, total):
    global min_value, max_value
    if k == N:
        min_value = min(min_value, total)
        max_value = max(max_value, total)
        return
    
    if count[0] >= 1:
        count[0] -= 1
        dfs(k+1, total + A[k])
        count[0] += 1
    if count[1] >= 1:
        count[1] -= 1
        dfs(k+1, total - A[k])
        count[1] += 1
    if count[2] >= 1:
        count[2] -= 1
        dfs(k+1, total * A[k])
        count[2] += 1
    if count[3] >= 1:
        count[3] -= 1
        if total < 0:
            dfs(k+1, -(-total // A[k]))
        else:
            dfs(k+1, total // A[k])
        count[3] += 1

dfs(1, A[0])
print(max_value)
print(min_value)
