# 카드 게임 (5522번)
import sys
input = sys.stdin.readline

total_score = 0
for i in range(5):
    total_score += int(input().rstrip())

print(total_score)