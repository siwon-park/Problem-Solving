# Basketball Score (32306번)
s1, s2, s3 = map(int, input().rstrip().split())
s4, s5, s6 = map(int, input().rstrip().split())

total1 = s1 + s2 * 2 + s3 * 3
total2 = s4 + s5 * 2 + s6 * 3
if total1 == total2:
    print(0)
elif total1 > total2:
    print(1)
else:
    print(2)
