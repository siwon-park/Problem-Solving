import sys

input = sys.stdin.readline

# Terms of Office (6888번)
X = int(input().rstrip())
Y = int(input().rstrip())
for i in range(X, Y + 1, 60):
    print(f"All positions change in year {i}")

