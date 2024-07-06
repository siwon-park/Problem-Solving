# 야바위 대장 (15814번)
import sys
input = sys.stdin.readline

S = list(input().rstrip())
T = int(input().rstrip())
for i in range(T):
    A, B = map(int, input().rstrip().split())
    S[A], S[B] = S[B], S[A]

print("".join(S))

