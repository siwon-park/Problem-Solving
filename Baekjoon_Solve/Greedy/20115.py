# 에너지 드링크(20115번)
##############################################################################################
    # 문제: https://www.acmicpc.net/problem/20115
    # 그리디
    # 입력으로 주어진 음료수들의 양을 정렬한 다음
    # 가장 큰 음료수에게 절반씩 더해주면 된다.
##############################################################################################
import sys
input = sys.stdin.readline

N = int(input())
lst = list(map(int, input().split()))
lst.sort()

base = lst[-1]
for i in range(N - 1):
    base += lst[i] / 2

print(base)
