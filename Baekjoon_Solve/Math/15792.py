import sys, decimal

input = sys.stdin.readline

# A/B - 2 (15792번)
A_str, B_str = input().rstrip().split()
decimal.getcontext().prec = max(len(A_str), len(B_str)) + 1100
A, B = map(int, (A_str, B_str))
res = decimal.Decimal(A) / decimal.Decimal(B)
print(format(res, 'f'))
