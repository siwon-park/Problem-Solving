#31450번
m, k = map(int, input().rstrip().split())
if m % k == 0:
    print("Yes")
else:
    print("No")