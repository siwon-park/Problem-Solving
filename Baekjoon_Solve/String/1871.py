# 좋은 자동차 번호판 (1871번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
for i in range(N):
    lst = input().rstrip().split("-")
    tmp = lst[0]
    LLL = 0
    for j in range(2, -1, -1):
        LLL += (ord(tmp[j]) - 65) * (26 ** (2 - j))
    DDDD = int(lst[1])
    ret = abs(LLL - DDDD)
    if ret <= 100:
        print("nice")
    else:
        print("not nice")

