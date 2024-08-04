# 화성 수학 (5355번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for i in range(T):
    info = input().rstrip().split()
    num = float(info[0])
    m = len(info)
    for j in range(1, m):
        if info[j] == '@':
            num *= 3
        elif info[j] == '%':
            num += 5
        elif info[j] == '#':
            num -= 7
    print(f'{num:.2f}')

