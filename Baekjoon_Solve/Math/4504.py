# 배수 찾기 (4504번)
n = int(input().rstrip())
while True:
    m = int(input().rstrip())
    if m == 0:
        break
    if m % n == 0:
        print(f'{m} is a multiple of {n}.')
    else:
        print(f'{m} is NOT a multiple of {n}.')
