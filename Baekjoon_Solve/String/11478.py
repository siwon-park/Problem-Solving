# 서로 다른 부분 문자열의 개수 (11478번)
"""
  문제: https://www.acmicpc.net/problem/11478
  문자열, 집합
  S의 최대 길이가 1000이므로 2중 반복문을 통해 O(1000^2)의 시간으로 문제를 해결할 수 있다.
  부분문자열을 집합에 담고, 해당 집합의 길이를 출력하면 된다.
"""
import sys
input = sys.stdin.readline

S = input().rstrip()
N = len(S)
_set = set()

for i in range(N):
    s = ""
    for j in range(i, N):
        s += S[j]
        _set.add(s)

print(len(_set))
