import sys
input = sys.stdin.readline

# 더하기 4 (11024번)
N = int(input().rstrip())
for i in range(N):
    print(sum(list(map(int, input().rstrip().split()))))

