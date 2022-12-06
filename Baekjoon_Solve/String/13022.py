# 늑대와 올바른 단어 (13022번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/13022
    # 문자열
    # 문제 조건에 잘 맞게 구현만 하면 된다.
    # 혹 간혹가다 채점 도중에 틀린다면, 맨 마지막에 반복문을 다 돌고나서, w, o, l, f의 개수가 모두 같은지 확인하는 절차가 한 번 더 필요하다
    # 예를 들어, (내 코드 상으로는) wwwoollff와 같이 도중에 잘못되었는데 맨 마지막에 추가로 확인해줘야 할 수도 있다.
##########################################################################
import sys
input = sys.stdin.readline

word = input().rstrip()


def check(word):
    last = "w"
    w, o, l, f = 0, 0, 0, 0
    for s in word:
        if s == "w":
            if last != "w" and last != "f":
                return 0
            elif last == "f":
                if not (w == o and o == l and l == f and f == w):
                    return 0
            w += 1
        elif s == "o":
            if last != "o" and last != "w":
                return 0
            o += 1
        elif s == "l":
            if last != "l" and last != "o":
                return 0
            l += 1
        elif s == "f":
            if last != "f" and last != "l":
                return 0
            f += 1
        last = s

    if not (w == o and o == l and l == f and f == w):
        return 0
    return 1


print(check(word))
