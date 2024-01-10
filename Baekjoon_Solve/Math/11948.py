# 과목선택 (11948번)
import sys
input = sys.stdin.readline

A = int(input().rstrip())
B = int(input().rstrip())
C = int(input().rstrip())
D = int(input().rstrip())
E = int(input().rstrip())
F = int(input().rstrip())

lst = [A, B, C, D]
lst.sort(reverse=True)
print(sum(lst[:3]) + max(E, F))

