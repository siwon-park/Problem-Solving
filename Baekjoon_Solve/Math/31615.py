# 桁 (Digit) (31615번)
# 두 수를 더해서 몇 자리수가 되는지 구하는 문제인듯
A = int(input().rstrip())
B = int(input().rstrip())
total = A + B
digits = 0
while total > 0:
    total //= 10
    digits += 1

print(digits)

