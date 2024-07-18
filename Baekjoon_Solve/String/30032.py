# 알파벳 뒤집기 (30032번)
import sys
input = sys.stdin.readline

N, D = map(int, input().rstrip().split())
lst = [{"d": "q", "b": "p", "q": "d", "p": "b"}, {"d": "b", "b": "d", "q": "p", "p": "q"}]

for i in range(N):
    word = input().rstrip()
    ans = ""
    for w in word:
        ans += lst[D - 1][w]
    print(ans)

