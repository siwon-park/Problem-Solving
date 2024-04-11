# 복붙의 달인 (11008번)
import sys
input = sys.stdin.readline

TC = int(input().rstrip())
for tc in range(TC):
    s, p = input().rstrip().split()
    replaced = s.replace(p, " ")
    print(len(replaced))

