# 시간복잡도를 배운 도도(24510번)
##################################################
    # 문제: https://www.acmicpc.net/problem/24510
    # 문자열
    # replace메서드를 활용해 간단하게 해결하였음
##################################################
import sys
input = sys.stdin.readline

C = int(input())
max_v = 0
for _ in range(C):
    l = input().rstrip()
    l = l.replace("for","1")
    l = l.replace("while","1")
    max_v = max(max_v, l.count("1"))
print(max_v)
