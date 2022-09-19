# 222-풀링(17829번)
#########################################################################################
    # 문제: https://www.acmicpc.net/problem/17829
    # 재귀, 분할 정복
    # w가 1이되면 graph[r][c]를 return하고,
    # 값을 4등분으로 분할한 뒤에 얻어지는 값을 정렬해서 2번째 값만 뽑아오는 방식으로 구현하였고
    # 최종적으로 lst[-2]의 값을 반환하면 된다.
#########################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

MIN_NUM = -sys.maxsize

def recur(r, c, w):
    if w == 1:
        return graph[r][c]

    num1 = recur(r, c, w // 2)
    num2 = recur(r + w // 2, c, w // 2)
    num3 = recur(r, c + w // 2, w // 2)
    num4 = recur(r + w // 2, c + w // 2, w // 2)

    lst = [num1, num2, num3, num4]
    lst.sort()

    return lst[-2]

print(recur(0, 0, N))
