# 인공지능 시계 (2530번)
import sys
input = sys.stdin.readline

A, B, C = map(int, input().rstrip().split())
D = int(input().rstrip())
ss = D % 60
mm = (D // 60) % 60
hh = (D // 60) // 60

A += hh
B += mm
C += ss

B += C // 60
C %= 60

A += B // 60
B %= 60
A %= 24
print(A, B, C)

