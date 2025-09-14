import sys

input = sys.stdin.readline

# 숭고한에 어서오세요 (34236번)
N = int(input().rstrip())
A = list(map(int, input().rstrip().split()))
diff = A[1] - A[0]
print(A[-1] + diff)

