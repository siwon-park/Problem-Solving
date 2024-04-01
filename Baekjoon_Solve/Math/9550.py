# 아이들은 사탕을 좋아해 (9550번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for tc in range(T):
    N, K = map(int, input().rstrip().split())
    total = 0
    candies = list(map(int, input().rstrip().split()))
    for i in range(N):
        total += candies[i] // K
    print(total)

