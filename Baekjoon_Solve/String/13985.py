# Equality (13985번)
line = input().rstrip().split()
a = int(line[0])
b = int(line[2])
c = int(line[4])
if a + b == c:
    print("YES")
else:
    print("NO")
