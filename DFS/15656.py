# N과 M(7) (15656번)
#########################################################
    # 문제: https://www.acmicpc.net/problem/15656
    # 재귀
    # 중복해서 M개까지 고르면 되므로, k==M이 되는 종료조건 외에 다른 조건은 넣지 않아도 되는 간단한 문제였다.
#########################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

ret = []
def comb(k, lst):
    if k == M:
        print(*lst[:])
        return
    for i in range(N):
        comb(k+1, lst+[arr[i]])

comb(0, [])
