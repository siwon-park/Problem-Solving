# 닉네임에 갓 붙이기 (13163번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
for _ in range(N):
    lst = input().rstrip().split()
    lst[0] = "god"
    print("".join(lst))
