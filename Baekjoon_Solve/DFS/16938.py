# 캠프 준비(16938번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/16938
    # 백트랙킹, 조합
    # 특정 조건 - 두 문제 이상, 문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다, 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다
    # 을 만족하는 조합을 찾는 문제이다.
    # 가장 어려운 문제와 가장 쉬운 문제의 난이도 차를 계산하기 위해 정렬을 사용하였다. 이렇게 할 경우 i번째 선택하는 문제는 무조건 가장 큰 난이도가 된다.
    # 하지만 가장 작은 난이도를 계산함에 있어서 원하는대로 잘 안돼서 N <= 15이니 리스트에 요소를 담는 방법으로 2개 이상의 문제를 택했을 때
    # lst[-1] - lst[0]을 하는 방법으로 해결하였다.
########################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, L, R, X = map(int, input().split())
A = list(map(int, input().split()))
A.sort() # 정렬

cnt = 0
def dfs(k, s, total, lst):
    global cnt
    if total > R:
        return
    if k >= 2 and L <= total <= R and lst[-1] - lst[0] >= X:
        cnt += 1
    for i in range(s, N):
        total += A[i]
        lst.append(A[i])
        dfs(k+1, i+1, total, lst)
        lst.pop()
        total -= A[i]

dfs(0, 0, 0, [])
print(cnt)
