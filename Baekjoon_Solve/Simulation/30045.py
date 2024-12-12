n = int(input().rstrip())
cnt = 0
for i in range(n):
    s = input().rstrip()
    if '01' in s or 'OI' in s:
        cnt += 1

print(cnt)
