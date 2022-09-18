# 종이의 개수(1780번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/1780
    # 재귀, 분할 정복
    # 이전에 풀었던 코드를 참고해서 풀었는데, 시간초과가 나서 결국에는 다른 사람의 풀이를 보았다.
    # 역시 재귀, 분할 정복은 아직도 나에게 어려운 것 같다.
    # 분할, 재귀까진 좋은데, 기준점에 대해 아직도 이해가 잘 안 간다.
    # 그래도 계속 쉬운 문제부터 연습해야겠다.
    # 풀이는 아래 주석을 참고하면 된다.
######################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

def recur(r, c, w):
    global ans1, ans2, ans3

    cur = graph[r][c] # 현재 위치의 종이 번호
    for i in range(r, r + w):
        for j in range(c, c + w):
            if graph[i][j] != cur: # 현재 위치의 종이번호와 다르면 9개가 안 되므로 분할
                recur(r, c, w // 3)  # (0, 0, 3)
                recur(r + w // 3, c, w // 3)  # (1, 0, 3)
                recur(r + 2 * w // 3, c, w // 3)  # (2, 0, 3)
                recur(r, c + w // 3, w // 3)  # (0, 1, 3)
                recur(r + w // 3, c + w // 3, w // 3)  # (1, 1, 3)
                recur(r + 2 * w // 3, c + w // 3, w // 3)  # (2, 1, 3)
                recur(r, c + 2 * w // 3, w // 3)  # (0, 2, 3)
                recur(r + w // 3, c + 2 * w // 3, w // 3)  # (1, 2, 3)
                recur(r + 2 * w // 3, c + 2 * w // 3, w // 3)  # (2, 2, 3)
                return # 리턴을 여기서 호출해줘야 한다. 왜냐하면 같지 않은데 for문을 빠져나왔을 경우에는 셀 필요가 없기 때문이다.

    if cur == -1:
        ans1 += 1
    elif cur == 0:
        ans2 += 1
    else:
        ans3 += 1
    return

ans1, ans2, ans3 = 0, 0, 0  # -1, 0, 1의 개수

recur(0, 0, N)

print(ans1)
print(ans2)
print(ans3)
