# 주사위 네개 (2484번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
_max = 0
for _ in range(N):
    lst = list(map(int, input().rstrip().split()))
    dic = dict()
    for i in range(4):
        dic[lst[i]] = dic.get(lst[i], 0) + 1

    count = [0 for _ in range(5)]
    for k, v in dic.items():
        count[v] = max(count[v], k)

    if count[4] != 0:
        _max = max(_max, 50000 + (count[4] * 5000))
    elif count[3] != 0:
        _max = max(_max, 10000 + (count[3] * 1000))
    elif count[2] != 0 and count[1] == 0:  # 같은 눈 두 짝
        prize = 2000
        for k, v in dic.items():
            prize += k * 500
        _max = max(_max, prize)
    elif count[2] != 0:
        _max = max(_max, 1000 + (count[2] * 100))
    else:
        _max = max(_max, count[1] * 100)

print(_max)

