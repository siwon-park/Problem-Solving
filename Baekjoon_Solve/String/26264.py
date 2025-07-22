import sys

input = sys.stdin.readline

# 빅데이터? 정보보호! (26264번)
n = int(input().rstrip())
s = input().rstrip()
secu_cnt = s.count("security")
bd_cnt = s.count("bigdata")

if secu_cnt > bd_cnt:
    print("security!")
elif bd_cnt > secu_cnt:
    print("bigdata?")
else:
    print("bigdata? security!")

