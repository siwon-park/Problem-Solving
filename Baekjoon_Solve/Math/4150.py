# 피보나치 수 (4150번)
import sys
input = sys.stdin.readline

fb0, fb1 = 0, 1
n = int(input().rstrip())
for i in range(2, n + 1):
    fb = fb0 + fb1
    fb0 = fb1
    fb1 = fb

print(fb1)

