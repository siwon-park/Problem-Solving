n = int(input().rstrip())
if -32768 <= n <= 32767:
    print("short")
elif -2147483648 <= n <= 2147483647:
    print("int")
else:
    print("long long")