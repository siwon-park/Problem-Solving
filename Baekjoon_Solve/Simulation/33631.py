import sys

input = sys.stdin.readline

# 1교시: 가정 (33631번)
fs, cs, es, bs = map(int, input().rstrip().split())
fn, cn, en, bn = map(int, input().rstrip().split())
n = int(input().rstrip())
cookies = 0
for _ in range(n):
    q, i = map(int, input().rstrip().split())
    if q == 1:
        if fs >= i * fn and cs >= i * cn and es >= i * en and bs >= i * bn:
            cookies += i
            print(cookies)
            fs -= i * fn
            cs -= i * cn
            es -= i * en
            bs -= i * bn
        else:
            print("Hello, siumii")
    elif q == 2:
        fs += i
        print(fs)
    elif q == 3:
        cs += i
        print(cs)
    elif q == 4:
        es += i
        print(es)
    elif q == 5:
        bs += i
        print(bs)
