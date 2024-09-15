# Area (28490번)
n = int(input().rstrip())
_max = 0
for i in range(n):
    w, h = map(int, input().rstrip().split())
    _max = max(_max, w * h)
    
print(_max)