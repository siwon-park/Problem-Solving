import sys
from collections import deque

input = sys.stdin.readline

# Olympiad Pizza (15235번)
N = int(input().rstrip())
queue = deque([])
lst = list(map(int, input().rstrip().split()))
for i, e in enumerate(lst):
    queue.append((i, e))

result = [0 for _ in range(N)]
s = 0
while queue:
    idx, num = queue.popleft()
    s += 1
    result[idx] = s
    num -= 1
    if num > 0:
        queue.append((idx, num))

print(*result)

