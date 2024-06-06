# 대표값 (2592번)
import sys
input = sys.stdin.readline

avg = 0
dic = dict()
for i in range(10):
    num = int(input().rstrip())
    avg += num
    dic[num] = dic.get(num, 0) + 1

lst = list(dic.items())
lst.sort(key=lambda x: -x[1])

print(avg // 10)
print(lst[0][0])

