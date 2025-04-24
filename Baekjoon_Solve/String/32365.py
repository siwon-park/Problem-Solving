import sys

input = sys.stdin.readline

# Heavy-Light Composition (32365번)
n, m = map(int, input().rstrip().split())
for i in range(n):
    _dict = dict()
    s = list(input().rstrip())
    for j in range(m):
        _dict[s[j]] = _dict.get(s[j], 0) + 1
    hl = ""
    if _dict.get(s[0]) > 1:
        hl += 'h'
    else:
        hl += 'l'
    flag = True
    for j in range(1, m):
        cur = ''
        if _dict.get(s[j]) > 1:
            cur = 'h'
            hl += cur
        else:
            cur = 'l'
            hl += cur
        if hl[j - 1] == cur:
            flag = False

    if flag:
        print('T')
    else:
        print('F')

