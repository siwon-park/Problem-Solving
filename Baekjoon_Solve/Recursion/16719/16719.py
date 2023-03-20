import sys
input = sys.stdin.readline

S = input().rstrip()
N = len(S)
visited = [False] * N
ret = []


def recur(l: int, r: int) -> None:
    _min = 'a'
    idx = N
    for i in range(l, r):
        if not visited[i] and S[i] < _min:
            _min = S[i]
            idx = i
    if idx == N:
        return
    visited[idx] = True
    s = ""
    for i in range(N):
        if visited[i]:
            s += S[i]
    ret.append(s)
    recur(idx + 1, r)
    recur(l, idx)


recur(0, N)

for _ret in ret:
    print(_ret)