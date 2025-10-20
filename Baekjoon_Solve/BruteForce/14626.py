import sys

input = sys.stdin.readline

# ISBN (14626번)
ISBN = input().rstrip()

k = 1
total = 0
for i in range(13):
    if ISBN[i] == '*':
        if i % 2 == 0:
            k = 1
        else:
            k = 3
        continue
    if i % 2 == 0:
        total += int(ISBN[i]) * 1
    else:
        total += int(ISBN[i]) * 3

for i in range(10):
    if (total + i * k) % 10 == 0:
        print(i)
        break

