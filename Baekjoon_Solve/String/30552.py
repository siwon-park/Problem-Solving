import sys

input = sys.stdin.readline

# 30552번
n = int(input().rstrip())
lst = [input().rstrip() for _ in range(n)]
attnd = []
for i in range(n):
    if lst[i] == "Present!":
        continue
    if i + 1 < n and lst[i + 1] == "Present!":
        continue
    attnd.append(lst[i])

if not attnd:
    print("No Absences")
else:
    for name in attnd:
        print(name)

