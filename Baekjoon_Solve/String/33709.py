import sys

input = sys.stdin.readline

# 치매예방수칙 3.3.3 (33709번)
n = int(input().rstrip())
s = input().rstrip()
s = s.replace('.', ' ')
s = s.replace('|', ' ')
s = s.replace(':', ' ')
s = s.replace('#', ' ')
print(sum(list(map(int, s.split()))))
