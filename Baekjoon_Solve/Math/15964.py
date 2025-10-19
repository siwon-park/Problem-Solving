import sys

input = sys.stdin.readline

# 이상한 기호 (15964번)
def calculate(a: int, b: int) -> int:
    return (a + b) * (a - b)

A, B = map(int, input().rstrip().split())
print(calculate(A, B))

