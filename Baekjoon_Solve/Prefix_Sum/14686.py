import sys

input = sys.stdin.readline

# Sum Game (14686번)
N = int(input().rstrip())
lst1 = list(map(int, input().rstrip().split()))
lst2 = list(map(int, input().rstrip().split()))

for i in range(1, N):
    lst1[i] += lst1[i - 1]
    lst2[i] += lst2[i - 1]

k = 0
for i in range(N):
    if lst1[i] == lst2[i]:
        k = i + 1

print(k)

