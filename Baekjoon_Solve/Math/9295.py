n = int(input().rstrip())
for i in range(n):
    a, b = map(int, input().rstrip().split())
    print(f'Case {i + 1}: {a + b}')
    