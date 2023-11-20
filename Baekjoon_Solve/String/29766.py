# DKSH 찾기 (29766번)
import sys
input = sys.stdin.readline

cnt = 0
line = input().rstrip()
N = len(line)
for i in range(N - 3):
    if line[i:i+4] == "DKSH":
        cnt += 1

print(cnt)
