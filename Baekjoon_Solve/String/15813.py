# 너의 이름은 몇 점이니? (15813번)
import sys
input = sys.stdin.readline

n = int(input().rstrip())
name = input().rstrip()
score = 0
for i in range(n):
    score += ord(name[i]) - 64

print(score)

