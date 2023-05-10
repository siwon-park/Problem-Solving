# 역원소 정렬 (5648번)
import sys
input = sys.stdin.readline

lst = []
first_input = input().rstrip().split()
n = int(first_input[0])
lst.extend(first_input[1:])
m = len(first_input) - 1
while m < n:
    tmp = input().rstrip().split()
    lst.extend(tmp)
    m += len(tmp)

sort_lst = []
for i in range(n):
    str_num = lst[i]
    num = 0
    k = len(str_num)
    for j in range(k - 1, -1, -1):
        num = num * 10 + int(str_num[j])
    sort_lst.append(num)

sort_lst.sort()
for num in sort_lst:
    print(num)