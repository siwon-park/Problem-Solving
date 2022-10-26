# 임스와 함께하는 미니게임 (25757번)
#######################################################################
    # 문제: https://www.acmicpc.net/problem/25757
    # 집합 자료형을 사용해서 각 게임 종류별로 집합의 길이를 나눈 몫을 출력하면 정답이다.
#######################################################################
import sys
input = sys.stdin.readline

N, K = input().rstrip().split()
N = int(N)
players = set()
for _ in range(N):
    players.add(input().rstrip())

M = len(players)

if K == "Y":
    print(M)
elif K == "F":
    print(M // 2)
elif K == "O":
    print(M // 3)
