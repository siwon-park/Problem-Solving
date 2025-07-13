# 27541번
n = int(input().rstrip())
s = input().rstrip()
if s[-1] == "G":
    print(s[:n-1])
else:
    print(s + "G")
