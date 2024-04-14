# 제 2회 IUPC는 잘 개최될 수 있을까? (12788번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
M, K = map(int, input().rstrip().split())  # 팀의 수, 팀원의 수
A = list(map(int, input().rstrip().split()))
A.sort(reverse=True)

total = M * K
cur = 0
ans = 0
for i in range(N):
    cur += A[i]
    ans += 1
    if cur >= total:
        break

if cur < total:
    print("STRESS")
else:
    print(ans)

