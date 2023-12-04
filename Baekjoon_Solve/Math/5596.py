# 시험 점수 (5596번)
import sys
input = sys.stdin.readline

m1, m2, m3, m4 = map(int, input().rstrip().split())
n1, n2, n3, n4 = map(int, input().rstrip().split())

S = m1 + m2 + m3 + m4
T = n1 + n2 + n3 + n4
print(max(S, T))
