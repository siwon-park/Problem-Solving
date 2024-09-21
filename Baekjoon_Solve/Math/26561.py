# Population (26561번)
n = int(input().rstrip())
for i in range(n):
    p, t = map(int, input().rstrip().split())
    print(p - t // 7 + t // 4)
