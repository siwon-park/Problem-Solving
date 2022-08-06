# N과 M(9) (15663번)
##########################################################
    # 문제: https://www.acmicpc.net/problem/15663
    # 재귀, 백트랙킹
    # 중복을 피하기위해 집합과 문자열을 사용함
    # 168ms인 것으로 보아 그리 효율적인 코드는 아닌듯...?
##########################################################
import sys
input = sys.stdin.readline

def combine(k, lst, chk, arr):
    if k == M:
        if chk not in s:
            print(*lst)
            s.add(chk)
        return
    for e in arr:
        left_arr = arr[:]
        left_arr.remove(e)
        combine(k+1, lst+[e], chk+str(e), left_arr)

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
s = set()

combine(0, [], "", arr)
