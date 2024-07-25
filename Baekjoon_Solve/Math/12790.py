# Mini Fantasy War (12790번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for i in range(T):
    hp1, mp1, attk1, def1, hp2, mp2, attk2, def2 = map(int, input().rstrip().split())
    print(max(1, hp1 + hp2) + 5 * max(1, (mp1 + mp2)) + 2 * max(0, (attk1 + attk2)) + 2 * (def1 + def2))

