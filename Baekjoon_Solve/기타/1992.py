# 쿼드트리(1992번)
#############################################################################
    # 문제: https://www.acmicpc.net/problem/1992
    # 분할정복
    # 4개의 결과가 모두 0이거나 1일 때만 0 또는 1로 압축해서 표현하지, 그 외에는 전부 괄호와 함께 전부 표현해야 한다.
    # 왜 틀렸는지 원인을 못찾았는데, if ret1 == ret2 == ret3 == ret4에서 그냥 4개의 값이 모두 같은지만 확인하고 있어서 그렇다.
    # 이 경우, 결과들이 압축된 형태가 되어 틀린 답이 나온다.
    # 예를 들어, 4 1010 0000 1010 0000으로 입력할 경우 답은 ((1000)(1000)(1000)(1000))이지만, 4개의 값만 같은지 확인할 경우 1000으로 나온다.
#############################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
graph = [list(input().rstrip()) for _ in range(N)]

def recur(r, c, w):
    if w == 1:
        return graph[r][c]

    ret1 = recur(r, c, w // 2)
    ret2 = recur(r, c + w // 2, w // 2)
    ret3 = recur(r + w // 2, c, w // 2)
    ret4 = recur(r + w // 2, c + w // 2, w // 2)

    if ret1 == ret2 == ret3 == ret4 and (ret1 == "1" or ret1 == "0"):
        return ret1
    return "(" + ret1 + ret2 + ret3 + ret4 + ")"

print(recur(0, 0, N))
