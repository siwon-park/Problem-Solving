import sys
input = sys.stdin.readline

# Application List (32903번)
n = int(input().rstrip())
arr = [["." for i in range(6)] for j in range(4)]
arr.append([".", "."])

for i in range(n):
    w = input().rstrip()
    _prefix = w[0]
    idx = ord(_prefix) - 97
    arr[idx // 6][idx % 6] = _prefix

for lst in arr:
    print("".join(lst))

