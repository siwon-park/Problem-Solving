# 수 뒤집기 (3062번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for _ in range(T):
    str_num = input().rstrip()
    rev_str_num = str_num[::-1]
    ret = int(str_num) + int(rev_str_num)
    rev_ret = str(ret)[::-1]
    if ret == int(rev_ret):
        print("YES")
    else:
        print("NO")

