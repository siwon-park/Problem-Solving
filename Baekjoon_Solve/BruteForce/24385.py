import sys

input = sys.stdin.readline

# СПОРТ (24385번)
S = input().rstrip()
m = len(S)
visited = [False] * m
result = []

def backtrack(k: int, word: str) -> None:
    global S, m, visited, result
    if k == m:
        result.append(word)
        return
    for i in range(m):
        if not visited[i]:
            visited[i] = True
            backtrack(k + 1, word + S[i])
            visited[i] = False

backtrack(0, "")

result.sort()
for res in result:
    print(res)
