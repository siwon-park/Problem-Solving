import sys
input = sys.stdin.readline

T = int(input().rstrip())
for _ in range(T):
    N = int(input().rstrip())
    coins = list(map(int, input().rstrip().split()))
    M = int(input().rstrip())
    dp = [0] * 10001
    for n in range(N):
        coin = coins[n]
        dp[coin] += 1 # dp 배열을 M + 1 크기로 선언하면 N개의 동전 중 M보다 큰 금액이 있으면 여기서 인덱스 에러 발생
        for m in range(1, M + 1):
            if m - coin >= 0:
                dp[m] += dp[m - coin]
    print(dp[M])
