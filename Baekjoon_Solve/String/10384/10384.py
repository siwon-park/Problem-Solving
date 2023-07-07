# 팬그램 (10384번)
import sys
input = sys.stdin.readline

n = int(input().rstrip())
for t in range(1, n + 1):
    count = [0] * 26
    words = input().rstrip()
    for s in words:
        m = ord(s)
        if 65 <= m <= 90:
            m += 32
            count[m - 97] += 1
        elif 97 <= m <= 122:
            count[m - 97] += 1

    _set = set(count)
    # 집합의 등장한 숫자 최솟값에 따라 결정
    if min(_set) == 0:
        print(f'Case {t}: Not a pangram')
    elif min(_set) == 1:
        print(f'Case {t}: Pangram!')
    elif min(_set) == 2:
        print(f'Case {t}: Double pangram!!')
    elif min(_set) >= 3:
        print(f'Case {t}: Triple pangram!!!')