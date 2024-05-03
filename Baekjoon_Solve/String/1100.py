# 하얀 칸 (1100번)
import sys
input = sys.stdin.readline

ans = 0
for i in range(8):
    line = input().rstrip()
    if i % 2 == 0:
        for j in range(0, 8, 2):
            if line[j] == 'F':
                ans += 1
    else:
        for j in range(1, 8, 2):
            if line[j] == 'F':
                ans += 1

print(ans)

