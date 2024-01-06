# KMP는 왜 KMP일까? (2902번)
import sys
input = sys.stdin.readline


algo_name_lst = input().rstrip().split("-")
n = len(algo_name_lst)
ans = ""
for i in range(n):
    ans += algo_name_lst[i][0]

print(ans)
