# 관공... 어찌하여 목만 오셨소... (30501번)
import sys
input = sys.stdin.readline

suspect = ""
N = int(input().rstrip())
for _ in range(N):
    name = input().rstrip()
    if "S" in name:
        suspect = name

print(suspect)
