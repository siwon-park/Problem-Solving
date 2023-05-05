# 탈출 (16397번)
import sys
from collections import deque
input = sys.stdin.readline

N, T, G = map(int, input().rstrip().split())
MAX = int(1e5)


def bfs(n: int, t: int, g: int) -> int:
    q = deque([(n, 0)])
    visited = [False] * MAX
    visited[n] = True
    while q:
        cur_n, cur_t = q.popleft()
        if cur_n == g:
            return cur_t
        # A 버튼을 누름
        if cur_n + 1 < MAX:
            if cur_t + 1 <= t and not visited[cur_n + 1]:
                visited[cur_n + 1] = True
                q.append((cur_n + 1, cur_t + 1))
        # B 버튼을 누름
        if 0 < cur_n * 2 < MAX:
            double = cur_n * 2
            # 2를 곱한 다음에 0이 아닌 가장 높은 자리수의 숫자를 1 줄임
            if double < 10:
                double -= 1
            elif 10 <= double < 100:
                double -= 10
            elif 100 <= double < 1000:
                double -= 100
            elif 1000 <= double < 10000:
                double -= 1000
            elif 10000 <= double < 100000:
                double -= 10000
            if cur_t + 1 <= t and not visited[double]:
                visited[double] = True
                q.append((double, cur_t + 1))

    return -1


ret = bfs(N, T, G)
print("ANG" if ret == -1 else ret)