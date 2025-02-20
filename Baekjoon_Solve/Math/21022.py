import sys
input = sys.stdin.readline

# Three Points for a Win (21022번)
n = int(input().rstrip())
A = list(map(int, input().rstrip().split()))
B = list(map(int, input().rstrip().split()))
score = 0
for i in range(n):
    if A[i] > B[i]:
        score += 3
    elif A[i] == B[i]:
        score += 1

print(score)
