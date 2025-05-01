n = int(input().rstrip())
y = 2024
m = 1
m += n * 7
q = m // 12
r = m % 12
if r == 0:
    r = 12
    q -= 1
print(y + q, r)