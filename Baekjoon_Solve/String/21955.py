import sys
input = sys.stdin.readline

# Split (21955번)
N = input().rstrip()
n = len(N) // 2
print(N[:n], N[n:])

