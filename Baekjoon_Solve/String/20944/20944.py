# 팰린드롬 척화비 (20944번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
print("a" * (N // 2) + "a" * (N - 2 * (N // 2)) + "a" * (N // 2))