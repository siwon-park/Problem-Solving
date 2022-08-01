# A와 B 2 (12919번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/12919
    # 브루트포스, 재귀
    # S에서 T를 만드는 방법으로 시도를 했다. 물론 T에서 S로 갈 수도 있겠다 싶었지만 S와 T의 범위가 작아서 S에서 출발해도 효율성이 크게 차이가 없을 것이라 생각했다.
    # 하지만 이는 내 착각이었다. 처음에는 큐로 풀려고 시도했는데 메모리 초과가 났다.
    # 두번째는 문제 하단에서 문제 분류를 통해 재귀를 통해 푸는 것이라는 것을 알고 재귀로 풀었는데 시간초과를 받았다.
    # 나머지 3~4번째는 간단한 오타 및 로직상의 실수로 인해서 틀렸습니다를 받았다
    # 결국 T에서 S를 만드는 방법으로 해결했지만, 이 문제를 재귀로 풀어야한다는 것을 캐치하지 못했기 때문에 마음이 시원하지는 않다.
    # 브루트포스는 진짜 더 연습해야겠다. 시간복잡도에 익숙해질 수 있는 좋은 유형이라고 생각한다.
#####################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

S = input().rstrip()
T = input().rstrip()
N = len(S)
def recur(t):
    if t == S:
        return 1
    if len(t) > N:
        if t[-1] == "A":
            if recur(t[:-1]):
                return 1
        if t[0] == "B":
            if recur(t[::-1][:-1]):
                return 1
    return 0

print(recur(T))