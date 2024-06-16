# 웰컴 키트 (30802번)
N = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
T, P = map(int, input().rstrip().split())

t = 0
for i in range(6):
    if lst[i] % T == 0:
        t += lst[i] // T
    else:
        t += (lst[i] // T) + 1

print(t)
print(N // P, N - ((N // P) * P))
