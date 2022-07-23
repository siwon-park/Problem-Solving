# 나무 자르기(14274번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/14247
    # 그리디
    # 나무를 자라는 길이를 기준으로 정렬해준 다움
    # 나무의 처음 길이 + 자라는 길이 * n번째 일을 누적해서 더해주면 된다.
##########################################################################
import sys
input = sys.stdin.readline

N = int(input())
trees = list(map(int, input().split()))
growth = list(map(int, input().split()))

lst = []
for i in range(N):
    lst.append((trees[i], growth[i]))

lst.sort(key=lambda x: x[1])

ans = 0
for i in range(N):
    t, g = lst[i]
    ans += t + g * i

print(ans)
