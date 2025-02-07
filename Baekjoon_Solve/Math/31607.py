# 31607번
a = int(input().rstrip())
b = int(input().rstrip())
c = int(input().rstrip())
if a + b == c or b + c == a or c + a == b:
    print(1)
else:
    print(0)
    