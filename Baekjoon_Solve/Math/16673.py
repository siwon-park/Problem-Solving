# 고려대학교에는 공식 와인이 있다(16673번)
c, k, p = map(int, input().rstrip().split())
total = 0
for i in range(1, c + 1):
    total += k * i + i * i * p
print(total)
