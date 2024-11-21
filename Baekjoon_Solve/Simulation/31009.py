n = int(input().rstrip())
lst = []
jinju_fee = 0
for i in range(n):
    d, c = input().rstrip().split()
    c = int(c)
    if d == "jinju":
        jinju_fee = c
    lst.append((d, c))

cnt = 0
for i in range(n):
    if lst[i][1] > jinju_fee:
        cnt += 1
        
print(jinju_fee)
print(cnt)