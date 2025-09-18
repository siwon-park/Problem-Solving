import sys

input = sys.stdin.readline

# RICE SACK (9699번)
N = int(input().rstrip())
for i in range(1, N + 1):
    lst = list(map(int, input().rstrip().split()))
    print(f"Case #{i}: {max(lst)}")

