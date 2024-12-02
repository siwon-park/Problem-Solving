# 수수수수퍼노바 (32860번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
alpha = "ZABCDEFGHIJKLMNOPQRSTUVWXY"
nm = ""
if M <= 26:
    nm = alpha[M % 26]
else:
    if M % 26 == 0:
        nm = alpha[(M // 26) % 26 - 1] + alpha[M % 26]
    else:
        nm = alpha[(M // 26) % 26] + alpha[M % 26]
    nm = nm.lower()

print(f'SN {N}{nm}')

