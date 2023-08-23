# 몬스터를 처치하자! (20008번)
import sys
input = sys.stdin.readline

N, HP = map(int, input().rstrip().split())
skills = []
for i in range(N):
    skills.append(tuple(map(int, input().rstrip().split())))

cooltime = [0 for _ in range(N)]  # 쿨타임 배열
ans = int(1e9)


def backtrack(cur: int, left: int) -> None:
    global ans
    if left <= 0:
        ans = min(ans, cur)
        return
    flag = False  # 현재 시간에 스킬을 사용 가능
    for i in range(N):
        t = skills[i][0]  # 딜레이
        d = skills[i][1]  # 데미지
        if cooltime[i] <= cur:  # 쿨타임이 다 찬 시간보다 크면 스킬을 사용 가능
            flag = True
            last = cooltime[i]
            cooltime[i] = cur + t  # 다음 사용 가능한 시간 기록
            backtrack(cur + 1, left - d)
            cooltime[i] = last

    if not flag:  # 스킬 사용이 불가능하면 시간을 1초 증가시켜서 탐색
        backtrack(cur + 1, left)


backtrack(0, HP)
print(ans)
