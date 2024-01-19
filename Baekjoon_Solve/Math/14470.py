# 전자레인지 (14470번)
import sys
input = sys.stdin.readline

A = int(input().rstrip())
B = int(input().rstrip())
C = int(input().rstrip())
D = int(input().rstrip())
E = int(input().rstrip())

t = 0
if A < 0:  # 고기가 얼었을 경우
    t += abs(A) * C
    t += D
    t += abs(B) * E
else:
    t += abs(B - A) * E

print(t)

