# 이칙연산 (15726번)
a, b, c = map(int, input().rstrip().split())
print(a * max(b , c) // min(b, c))

