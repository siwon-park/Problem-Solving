# 인간-컴퓨터 상호작용 (16139번)
import sys
input = sys.stdin.readline

S = input().rstrip()
n = len(S)
arr = [[0 for _ in range(n + 1)] for _ in range(26)]

for i in range(n):
    c = ord(S[i]) - 97
    arr[c][i + 1] += 1

for i in range(26):
    for j in range(1, n + 1):
        arr[i][j] += arr[i][j - 1]

q = int(input().rstrip())
for _ in range(q):
    alpha, left, right = input().rstrip().split()
    l = int(left) + 1
    r = int(right) + 1
    k = ord(alpha) - 97
    print(arr[k][r] - arr[k][l - 1])
