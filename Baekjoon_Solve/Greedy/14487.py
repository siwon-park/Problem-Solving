# 욱제는 효도쟁이야!! (14487번)
import sys
input = sys.stdin.readline

n = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
total = sum(lst)
_max = max(lst)

print(total - _max)

