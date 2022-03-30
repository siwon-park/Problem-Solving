# 달나라 토끼를 위한 구매대금 지불 도우미(17212번)
##################################################################
    # 문제: https://www.acmicpc.net/problem/17212
    # 다이나믹 프로그래밍
    # 일반적인 거스름돈 문제
    # 반복문을 통한 점화식으로 풀어도 됐지만, 메모이제이션을 한번 적용시켜보았다.
    # 반복문에 비해 속도가 느리다는 것이 단점인 것 같다.
    # 재귀호출 제한을 풀어주는 것도 잊지 말자
##################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
memo = [0]*(N+1)

def dfs(k):
    if k == 0:
        return 0
    if memo[k]:
        return memo[k]
    l1 = l2 = l5 = l7 = int(1e9)    
    if k - 7 >= 0:
        l7 = dfs(k-7)
    if k - 5 >= 0:
        l5 = dfs(k-5)
    if k - 2 >= 0:
        l2 = dfs(k-2)
    if k - 1 >=0:
        l1 = dfs(k-1)
    memo[k] = min(l1, l2, l5, l7) + 1
    return memo[k]

dfs(N)
print(memo[N])
