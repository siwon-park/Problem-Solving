# DSLR(9019번)
#################################################################################
    # 문제: https://www.acmicpc.net/problem/9019
    # BFS
    # Python3로는 시간초과를 받았다.
    # L, R에 대해 숫자 -> 문자열 -> 숫자로 바꾸는 방식을 사용했는데, 사실 수학적으로 충분히 가능한 로직이었다.
    # 시간초과를 받았다는 것보다 처음에 시도했을 때, 수학적 기본 스킬 없이 구현하다보니 if문을 좀 더 썼다는 것에 부끄러움을 느낀다.
#################################################################################
import sys
from collections import deque
input = sys.stdin.readline

def bfs(A):
    q = deque([(A, '')])
    while q:
        cur, cmd = q.popleft()
        if cur == B:
            return cmd
        D = (cur * 2) % 10000 # cur*2가 9999보다 클 때 mod값을 넣으므로 이렇게 표현(어차피 2배 했는데도 작으면 나눠봤자 그대로임)
        S = 9999 if not cur else cur - 1
        L = (cur % 1000) * 10 + cur // 1000 # cur//1000은 cur의 첫째자리 수를 의미하고, 나머지 숫자는 cur을 1000으로 나눈 나머지에 10을 곱하면 왼쪽으로 한칸 이동한 결과가 나옴
        R = (cur % 10) * 1000 + cur // 10 # cur//10은 cur의 마지막자리 수를 의미하고, 나머지 숫자는 cur을 10으로 나눈 나머지에 1000을 곱하면 오른쪽으로 한칸 이동한 결과가 나옴
        if not visited[D]:
            visited[D] = cmd + "D"
            q.append((D, visited[D]))
        if not visited[S]:
            visited[S] = cmd + "S"
            q.append((S, visited[S]))
        if not visited[L]:
            visited[L] = cmd + "L"
            q.append((L, visited[L]))
        if not visited[R]:
            visited[R] = cmd + "R"
            q.append((R, visited[R]))

T = int(input())
for tc in range(T):
    A, B = map(int, input().split())
    visited = [False] * 10000
    visited[A] = True
    print(bfs(A))

