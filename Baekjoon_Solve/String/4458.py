# 첫 글자를 대문자로 (4458번)
n = int(input().rstrip())
for _ in range(n):
    lst = list(input().rstrip())
    lst[0] = lst[0].upper()
    print("".join(lst))