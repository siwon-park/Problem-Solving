import sys
sys.setrecursionlimit(10**4)

input = sys.stdin.readline

# 효구장 (34705번)
def backtrack(idx: int, total: int):
    global x, y, flag, k_beef
    if flag or total > y:
        return
    if x <= total <= y:
        flag = True
        return
    for i in range(idx, 5):
        backtrack(i + 1, total + k_beef[i])

T = int(input().rstrip())
for t in range(T):
    x, y = map(int, input().rstrip().split())
    flag = False
    k_beef = list(map(int, input().rstrip().split()))
    backtrack(0, 0)
    print("YES" if flag else "NO")

