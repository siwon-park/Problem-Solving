# 컨베이어 벨트 위의 로봇(20055번)
#########################################################################################
    # 문제: https://www.acmicpc.net/problem/20055
    # 구현, 시뮬레이션
    # 문제 이해가 잘 안돼서 조금 오래 걸렸던 문제이다. 나만 설명이 명확하지 않다고 생각했는데, 다른 사람도 비슷했나보다.
    # 효율성은 그리 좋지 못한데, 큐를 사용해서 일부 비효율적인 부분을 개선하면 Python3로도 통과가 가능할 것 같다.
    # 문제 이해가 안돼서 디버깅하는데 많은 시간을 써서 효율성 개선은 일단 생략하겠다.
#########################################################################################
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
belt = list(map(lambda x: [int(x), False], input().split()))

k = 0
t = 0
while k < K:
    # 벨트 회전
    belt = [belt[-1]] + belt[:-1]
    # print(belt)
    # 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한칸 이동시킨다.(거꾸로 탐색)
    # 일단 2*N의 위치에 있는 로봇부터 옮김
    if belt[2*N-1][1] and not belt[0][1] and belt[0][0] > 0:
        belt[0][1] = True
        belt[2*N-1][1] = False
        belt[0][0] -= 1
        if belt[0][0] == 0:
            k += 1
    for i in range(2*N - 1, 0, -1):
        if i-1 == N-1 and belt[i-1][1]:
            belt[i-1][1] = False
        if belt[i-1][1] and not belt[i][1] and belt[i][0] > 0:
            belt[i][0] -= 1
            belt[i][1] = True
            belt[i-1][1] = False
            if belt[i][0] == 0:
                k += 1
            if i == N - 1 and belt[i][1]:
                belt[i][1] = False
    # 로봇을 올릴 수 있다면 올린다.
    if belt[0][0] > 0 and not belt[0][1]:
        belt[0][1] = True
        belt[0][0] -= 1
        if belt[0][0] == 0:
            k += 1
    # print(belt, t, k)
    t += 1
print(t)
