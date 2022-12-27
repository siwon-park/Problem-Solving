# 놀라운 문자열 (1972번)
"""
    문제: https://www.acmicpc.net/problem/1972
    문자열, 해시맵
    문제에서 주어진 대로 D-쌍을 이룰 수 있도록 반복문을 돌려서 해당하는 부분 문자열을 구하고
    집합에 없으면 넣고, 있으면 return False한다.
"""
import sys
input = sys.stdin.readline


def is_unique(A: str) -> bool:
    for k in range(1, N):
        unique = set()
        for i in range(N - k):
            s = A[i] + A[i + k]
            if s not in unique:
                unique.add(s)
            else:
                return False
    return True


while True:
    S = input().rstrip()
    if S == "*":
        break
    N = len(S)
    ret = is_unique(S)
    if ret:
        print(f'{S} is surprising.')
    else:
        print(f'{S} is NOT surprising.')
