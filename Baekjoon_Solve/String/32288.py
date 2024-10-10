N = int(input().rstrip())
S = input().rstrip()
ans = ""
for w in S:
    if w == "I":
        ans += "i"
    elif w == "l":
        ans += "L"
        
print(ans)