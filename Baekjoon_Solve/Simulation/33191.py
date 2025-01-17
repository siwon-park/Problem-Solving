n = int(input().rstrip())
ans = "Nothing"
a = int(input().rstrip())
b = int(input().rstrip())
c = int(input().rstrip())

if n >= a:
    ans = "Watermelon"
elif n >= b:
    ans = "Pomegranates"
elif n >= c:
    ans = "Nuts"

print(ans)
      