import sys
input = sys.stdin.readline

# 너의 핸들은 (15819번)
N, I = map(int, input().rstrip().split())
lst = []
for i in range(N):
    lst.append(input().rstrip())

lst.sort()
print(lst[I - 1])

