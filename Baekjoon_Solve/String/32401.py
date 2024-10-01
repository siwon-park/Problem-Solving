# ANA는 회문이야 (32401번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
S = input().rstrip()

ans = 0
for i in range(N - 2):
    if S[i] == "A":
        n_cnt = 0
        last = ""
        for j in range(i + 1, N):
            last = S[j]
            if S[j] == "N":
                n_cnt += 1
            if S[j] == "A":
                break
        if n_cnt == 1 and last == "A":
            ans += 1

print(ans)

