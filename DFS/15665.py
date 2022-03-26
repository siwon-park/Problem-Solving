#N과 M(11) (15665번)
#########################################################
    # 문제: https://www.acmicpc.net/problem/15665
    # DFS, 백트랙킹
    # 중복 순열을 구하는 문제
    # 같은 수열 간 중복을 없애기 위해 집합형과 문자열을 사용했으나, 시간이 너무 많이 걸렸음 1300ms정도
    # 생각해보니까 처음에 arr를 받아올 때 set자료형으로 만들면 중복이 없어지고, 그 상태에서 중복 순열을 계산하면 되는 문제였다.
#########################################################
import sys
input = sys.stdin.readline

def permute(k, lst):
    if k == M:
        print(*lst)
        return
    for i in range(len(arr)):
        permute(k+1, lst+[arr[i]])    

N, M = map(int, input().split())
arr = list(set(map(int, input().split())))
arr.sort()
permute(0, [])
