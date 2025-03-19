import sys

input = sys.stdin.readline

# 뚊 (11383번)
N, M = map(int, input().rstrip().split())
lst1 = []
for i in range(N):
    s = input().rstrip()
    tmp = []
    for j in range(M):
        tmp.append(s[j])
        tmp.append(s[j])
    lst1.append("".join(tmp))

flag = True
for i in range(N):
    s = input().rstrip()
    if s != lst1[i]:
        flag = False

if not flag:
    print("Not Eyfa")
else:
    print("Eyfa")

