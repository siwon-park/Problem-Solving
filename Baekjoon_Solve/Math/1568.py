# 새 (1568번)
n = int(input().rstrip())
cnt = 0
k = 1

while n > 0:
    if k > n:
        k = 1
    n -= k
    k += 1
    cnt += 1
    
print(cnt)
    