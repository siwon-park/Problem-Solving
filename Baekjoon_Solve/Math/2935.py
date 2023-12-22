# 소음 (2935번)
import sys
input = sys.stdin.readline

A = int(input().rstrip())
operator = input().rstrip()
B = int(input().rstrip())

if operator == "+":
    print(A + B)
elif operator == "*":
    print(A * B)
