# 특별한 날 (10768번)
import sys
input = sys.stdin.readline

mm = int(input().rstrip())
dd = int(input().rstrip())

if mm == 2 and dd == 18:
    print("Special")
else:
    if mm >= 2 and dd > 18:
        print("After")
    elif mm > 2:
        print("After")
    else:
        print("Before")
