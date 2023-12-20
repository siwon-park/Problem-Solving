# 뉴비의 기준은 뭘까? (19944번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())

if M == 1 or M == 2:
    print("NEWBIE!")
elif M <= N:
    print("OLDBIE!")
else:
    print("TLE!")
