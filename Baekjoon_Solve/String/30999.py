# 민주주의(30999번)
n, m = map(int, input().rstrip().split())
ans = 0
for i in range(n):
    vote = input().rstrip()
    cnt = vote.count("O")
    if cnt >= m / 2:
        ans += 1

print(ans)
        