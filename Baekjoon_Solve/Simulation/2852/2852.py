import sys
input = sys.stdin.readline


def str_time_to_int(time: str) -> int:
    str_time = time.split(":")
    return int(str_time[0]) * 60 + int(str_time[1])


def int_time_to_str(time: int) -> str:
    MM = str(time // 60) if time // 60 >= 10 else "0" + str(time // 60)
    SS = str(time % 60) if time % 60 >= 10 else "0" + str(time % 60)
    return MM + ":" + SS


N = int(input().rstrip())
first, second = 0, 0 # 각 팀별 점수
first_winning, second_winning = 0, 0 # 각 팀별 이기고 있던 시간
last_time = 0 # 마지막 시간
for _ in range(N):
    record = input().rstrip().split()
    team_no = int(record[0]) # 팀 번호
    goal_time = str_time_to_int(record[1]) # 득점 시간
    if first > second: # 만약 1팀이 2팀을 이기고 있다면
        first_winning += goal_time - last_time
    elif second > first:
        second_winning += goal_time - last_time
    # 현재 득점한 팀에 따라 득점 누적
    if team_no == 1:
        first += 1
    else:
        second += 1
    last_time = goal_time

# 마지막 처리
if first > second:
    first_winning += 48 * 60 - last_time
elif second > first:
    second_winning += 48 * 60 - last_time

print(int_time_to_str(first_winning))
print(int_time_to_str(second_winning))