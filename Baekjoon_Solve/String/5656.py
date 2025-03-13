import sys

input = sys.stdin.readline

# 비교 연산자 (5656번)
cnt = 1
while True:
    ans = "false"
    equation = list(input().rstrip().split())
    n1 = int(equation[0])
    op = equation[1]
    n2 = int(equation[2])
    if op == "E":
        break
    if op == ">" and n1 > n2:
        ans = "true"
    elif op == ">=" and n1 >= n2:
        ans = "true"
    elif op == "<" and n1 < n2:
        ans = "true"
    elif op == "<=" and n1 <= n2:
        ans = "true"
    elif op == "==" and n1 == n2:
        ans = "true"
    elif op == "!=" and n1 != n2:
        ans = "true"
    print(f'Case {cnt}: {ans}')
    cnt += 1

