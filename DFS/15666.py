#N과 M(12) (15666번)
######################################################
    # 문제: https://www.acmicpc.net/problem/15666
    # DFS, 백트랙킹
    # 이번엔 백트랙킹으로 구현해보았다.
######################################################
import sys
input = sys.stdin.readline

# 백트랙킹으로 구현해보기
def back_tracking(s, k, lst):
    if k == M:
        print(*lst)
        return 
    if s == n:
        return
    for i in range(s, n):
        lst.append(arr[i])
        back_tracking(i, k+1, lst)
        lst.pop()


N, M = map(int, input().split())
arr = list(set(map(int, input().split())))
arr.sort()
n = len(arr)
back_tracking(0, 0, [])
