# 오늘도 졌다 (14582번)
import sys
input = sys.stdin.readline

woolim_geminus = list(map(int, input().rstrip().split()))
startlink_gullivers = list(map(int, input().rstrip().split()))

is_reversed = False
score1, score2 = 0, 0
for i in range(9):
    score1 += woolim_geminus[i]
    # 매회 초부터 공격을 시작하니 걸리버스 점수를 더하기 전에 체크해야 함
    if score1 > score2:
        is_reversed = True
    score2 += startlink_gullivers[i]

if is_reversed:
    print("Yes")
else:
    print("No")

