import sys

input = sys.stdin.readline

# 맥주 99병 (17293번)
N = int(input().rstrip())

cur = N
taken = 0
for _ in range(N + 1):
    if cur - 1 > 1:
        print(f'{cur} bottles of beer on the wall, {cur} bottles of beer.\n'
              f'Take one down and pass it around, {cur - 1} bottles of beer on the wall.')
        print()
    elif cur - 1 == 1:
        print(f'{cur} bottles of beer on the wall, {cur} bottles of beer.\n'
              f'Take one down and pass it around, {cur - 1} bottle of beer on the wall.')
        print()
    elif cur - 1 == 0:
        print(f'{cur} bottle of beer on the wall, {cur} bottle of beer.\n'
              f'Take one down and pass it around, no more bottles of beer on the wall.')
        print()
    else:
        if N > 1:
            print(f'No more bottles of beer on the wall, no more bottles of beer.\n'
                f'Go to the store and buy some more, {N} bottles of beer on the wall.')
        else:
            print(f'No more bottles of beer on the wall, no more bottles of beer.\n'
                f'Go to the store and buy some more, {N} bottle of beer on the wall.')
    cur -= 1

