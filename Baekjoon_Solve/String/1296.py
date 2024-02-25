# 팀 이름 정하기 (1296번)
import sys
input = sys.stdin.readline


def check(name: str) -> int:
    global L, O, V, E
    l, o, v, e = 0, 0, 0, 0
    for i in range(len(name)):
        if name[i] == 'L':
            l += 1
        elif name[i] == 'O':
            o += 1
        elif name[i] == 'V':
            v += 1
        elif name[i] == 'E':
            e += 1
    _L = L + l
    _O = O + o
    _V = V + v
    _E = E + e
    return ((_L + _O) * (_L + _V) * (_L + _E) * (_O + _V) * (_O + _E) * (_V + _E)) % 100


yeon = input().rstrip()
L, O, V, E = 0, 0, 0, 0
for i in range(len(yeon)):
    if yeon[i] == 'L':
        L += 1
    elif yeon[i] == 'O':
        O += 1
    elif yeon[i] == 'V':
        V += 1
    elif yeon[i] == 'E':
        E += 1

N = int(input().rstrip())
lst = []
for i in range(N):
    team = input().rstrip()
    p = check(team)
    lst.append((team, p))

lst.sort(key=lambda x: (-x[1], x[0]))

print(lst[0][0])

