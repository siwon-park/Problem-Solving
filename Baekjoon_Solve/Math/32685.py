# 4-LSB (32685번)
import sys
input = sys.stdin.readline

bin_num = ""
for i in range(3):
    num = int(input().rstrip())
    tmp = ""
    for j in range(3, -1, -1):
        if (num & (1 << j)) != 0:
            tmp += "1"
        else:
            tmp += "0"
    bin_num += tmp

ans = 0
for i in range(11, -1, -1):
    if bin_num[11 - i] == "1":
        ans += 1 << i

four_digit = str(ans)
n = len(four_digit)
if n <= 1:
    four_digit = "000" + four_digit
elif n <= 2:
    four_digit = "00" + four_digit
elif n <= 3:
    four_digit = "0" + four_digit

print(four_digit)

