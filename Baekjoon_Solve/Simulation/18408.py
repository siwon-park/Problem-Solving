one = 0
two = 0
lst = list(map(int, input().rstrip().split()))
for num in lst:
    if num == 1:
        one += 1
    elif num == 2:
        two += 1

if one > two:
    print(1)
else:
    print(2)
