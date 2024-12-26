# 왜 맘대로 예약하냐고 (32941번)
import sys
input = sys.stdin.readline

T, X = map(int, input().rstrip().split())
N = int(input().rstrip())
flag1 = True
for i in range(N):
    K = int(input().rstrip())
    flag2 = False
    lst = list(map(int, input().rstrip().split()))
    for j in range(K):
        if lst[j] == X:
            flag2 = True
    if not flag2:
        flag1 = False

if flag1:
    print("YES")
else:
    print("NO")

