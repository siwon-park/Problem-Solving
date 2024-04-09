line = input().rstrip()
is_ucpc = ""
i = 0
for s in line:
    if s == "U" and i == 0:
        is_ucpc += s
        i += 1
    elif s == "C" and i == 1:
        is_ucpc += s
        i += 1
    elif s == "P" and i == 2:
        is_ucpc += s
        i += 1
    elif s == "C" and i == 3:
        is_ucpc += s
        i += 1

if "UCPC" == is_ucpc:
    print("I love UCPC")
else:
    print("I hate UCPC")