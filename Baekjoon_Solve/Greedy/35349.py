import sys

input = sys.stdin.readline

# Card Game 4 (35349번)
n, k = map(int, input().rstrip().split())
cards = list(map(int, input().rstrip().split()))
cards.sort(reverse=True)

odd_sum, odd_cnt = 0, 0
even_sum, even_cnt = 0, 0
for i in range(n):
    if cards[i] % 2 and odd_cnt < k:
        odd_sum += cards[i]
        odd_cnt += 1
    elif cards[i] % 2 == 0 and even_cnt < k:
        even_sum += cards[i]
        even_cnt += 1

if odd_cnt == k and even_cnt == k:
    print(max(odd_sum, even_sum))
elif odd_cnt == k:
    print(odd_sum)
elif even_cnt == k:
    print(even_sum)
else:
    print(0)

