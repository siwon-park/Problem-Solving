# 저항 (1076번)
import sys
input = sys.stdin.readline

dic = {'black': 0, 'brown': 1, 'red': 2, 'orange': 3, 'yellow': 4, 'green': 5, 'blue': 6,
       'violet': 7, 'grey': 8, 'white': 9}

resist = 0
for i in range(2):
    color = input().rstrip()
    resist = resist * 10 + dic.get(color)

color = input().rstrip()
resist *= 10 ** dic.get(color)

print(resist)
