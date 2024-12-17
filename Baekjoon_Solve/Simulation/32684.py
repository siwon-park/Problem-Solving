# 장기 (32684번)
a1, b1, c1, d1, e1, f1 = map(int, input().rstrip().split())
a2, b2, c2, d2, e2, f2 = map(int, input().rstrip().split())
total1 = a1 * 13 + b1 * 7 + c1 * 5 + d1 * 3 + e1 * 3 + f1 * 2
total2 = a2 * 13 + b2 * 7 + c2 * 5 + d2 * 3 + e2 * 3 + f2 * 2 + 1.5
if total1 > total2:
    print("cocjr0208")
else:
    print("ekwoo")
