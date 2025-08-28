import sys

input = sys.stdin.readline

# Counting Vowels (18409번)
n = int(input().rstrip())
s = input().rstrip()
vowels = {'a', 'e', 'i', 'o', 'u'}

cnt = 0
for i in range(n):
    if s[i] in vowels:
        cnt += 1

print(cnt)

