import sys

input = sys.stdin.readline

# 당구 좀 치자 제발 (32642번)
N = int(input().rstrip())

lst = list(map(int, input().rstrip().split()))

ret = 0
ang = 0

for w in lst:
    if w == 1:
        ang += 1
    else:
        ang -= 1
    ret += ang

print(ret)
