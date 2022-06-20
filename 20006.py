# 랭킹전 대기열(20006번)
#######################################################################################
    # 문제: https://www.acmicpc.net/problem/20006
    # 구현, 시뮬레이션
    # 문제에 나온 과정을 그대로 코드로 구현하면 되는 문제이므로 크게 어려운 부분은 없었다.
    # 유저 네임을 사전순으로 출력해야한다는 점만 유의하면 된다.
#######################################################################################
import sys
input = sys.stdin.readline

p, m = map(int, input().split())
rooms = []
rn = 0 # 방의 수
room_dict = dict() # 방의 인원수를 계산하기 위한 딕셔너리
for _ in range(p):
    i, n = input().rstrip().split()
    i = int(i)
    # 방이 0개면 방을 만들고 유저를 넣음
    if rn == 0:
        rooms.append([(i, n)])
        room_dict[0] = 1
        rn += 1
    else:
        joinable = False
        # 입장 가능한 방이 있는지 확인
        for r in range(rn):
            # 먼저 생성된 입장 가능한 방에 넣음
            if abs(rooms[r][0][0] - i) <= 10 and room_dict[r] < m and not joinable:
                joinable = True
                rooms[r].append((i, n))
                room_dict[r] += 1
        # 입장할 수 없으면 방을 생성
        if not joinable:
            rooms.append([(i, n)])
            room_dict[rn] = 1
            rn += 1

for r in range(rn):
    rooms[r].sort(key=lambda x: x[1])
    if room_dict[r] == m:
        print("Started!")
    else:
        print("Waiting!")
    for user in rooms[r]:
        print(*user)
