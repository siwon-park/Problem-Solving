# 28453번
n = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
for i in range(n):
    if lst[i] < 250:
        print(4, end=" ")
    elif lst[i] < 275:
        print(3, end=" ")
    elif lst[i] < 300:
        print(2, end=" ")
    else:
        print(1, end=" ")
        