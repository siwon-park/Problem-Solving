# N과 M(10) (15664번)
############################################################
    # 문제: https://www.acmicpc.net/problem/15664
    # DFS, 재귀, 백트랙킹
    # 중복을 피하기 위해 인자로 문자열을 집합에 넣어서 검사하였음
    # 문자열을 넣을 때, 11 2, 12 1을 그냥 합쳐버리면 안 되므로, 구분자로 " "을 추가하였음
############################################################
import sys
input = sys.stdin.readline

def combine(s, k, lst, check):
    if k == M:
        if check not in comb:
            comb.add(check)
            print(*lst[:])
        return
    if s == N:
        return
    for i in range(s, N):
        combine(i+1, k+1, lst+[arr[i]], check+" "+str(arr[i]))

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
comb = set()
combine(0, 0, [], "")
