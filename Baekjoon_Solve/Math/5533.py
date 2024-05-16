# 유니크 (5533번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
r1, r2, r3 = dict(), dict(), dict()
lst = []
for i in range(N):
    s1, s2, s3 = map(int, input().rstrip().split())
    lst.append((s1, s2, s3))
    r1[s1] = r1.get(s1, 0) + 1
    r2[s2] = r2.get(s2, 0) + 1
    r3[s3] = r3.get(s3, 0) + 1

for i in range(N):
    ans = 0
    if r1[lst[i][0]] == 1:
        ans += lst[i][0]
    if r2[lst[i][1]] == 1:
        ans += lst[i][1]
    if r3[lst[i][2]] == 1:
        ans += lst[i][2]
    print(ans)

