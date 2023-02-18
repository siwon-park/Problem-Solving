# N과 M(8) (15657번)
#################################################
    # 문제: https://www.acmicpc.net/problem/15657
    # 재귀, 백트랙킹
    # 처음에 s==M으로 호출 종료 조건을 줘었는데, 그래선 안 됐다. 왜냐하면 s는 인덱스를 판별하기 위한 인자이기 때문에
    # 종료조건으로 M개를 뽑았다는 k라는 인자를 줘야했다. 처음에 그래서 원하는 대로 안 나와서 당황했었는데, 내 실수였다.
    # 오름차순 수열을 뽑되, 자기 자신은 여러 번 뽑을 수 있으므로, 함수 호출 시 매번 s==i로 고정을 해주면 된다.
#################################################
import sys
input = sys.stdin.readline

def comb(s, k, lst):
    if k == M:
        print(*lst)
        return
    for i in range(s, N):
        comb(i, k+1, lst+[arr[i]])

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

comb(0, 0, [])
