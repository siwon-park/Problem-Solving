# 단어순서 뒤집기 (12605번)
###########################################################################
    # 문제: https://www.acmicpc.net/problem/12605
    # 문자열
    # [::-1]을 사용하면 너무나도 쉽게 풀리는 문제.
###########################################################################
import sys
input = sys.stdin.readline

N = int(input())
for i in range(1, N + 1):
    line = list(input().rstrip().split())[::-1]
    print(f'Case #{i}:', " ".join(line))
