s = input().rstrip()
ans = ""
last = ""
for w in s:
    if w != last:
        ans += w
    last = w

print(ans)
