# 32209번
Q = int(input())
ret = 0
flag = True

for i in range(Q):
    a, b = map(int, input().rstrip().split())
    if a == 1:
        ret += b
    elif a == 2:
        ret -= b
    if ret < 0:
        flag = False

if flag:
    print("See you next month")
else:
    print("Adios")
