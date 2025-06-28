import sys

input = sys.stdin.readline

# 악질 검거 (31823번)
n, m = map(int, input().rstrip().split())
_set = set()
result = []
for i in range(n):
    lst = list(input().rstrip().split())
    name = lst[-1]
    max_streak = 0
    last = ""
    streak = 0
    for j in range(m):
        cur = lst[j]
        if cur == "." and cur == last:
            streak += 1
        elif cur == ".":
            streak = 1
        else:
            streak = 0
        last = cur
        max_streak = max(max_streak, streak)
    _set.add(max_streak)
    result.append((max_streak, name))

print(len(_set))
for s, nm in result:
    print(s, nm)

