# APC는 쉬운 난이도 순일까, 아닐까? (25955번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lvl_dict = {'B': 0, 'S': 1, 'G': 2, 'P': 3, 'D': 4}
lst = list(input().rstrip().split())

sorted_lst = []
for i in range(N):
    lvl = lst[i]
    sorted_lst.append((lvl_dict.get(lvl[0]), int(lvl[1:]), lvl))

sorted_lst.sort(key=lambda x: (x[0], -x[1]))
ans = []
for i in range(N):
    if sorted_lst[i][2] != lst[i]:
        ans.append(sorted_lst[i][2])

if not ans:
    print("OK")
else:
    print("KO")
    print(*ans)
