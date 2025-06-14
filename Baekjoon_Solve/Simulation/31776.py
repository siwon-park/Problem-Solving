import sys

input = sys.stdin.readline

# 예비 소집 결과 보고서 (31776번)
N = int(input().rstrip())
ans = 0
for i in range(N):
    lst = list(map(int, input().rstrip().split()))
    flag = True
    # 세 문제 다 풀지 않음
    if lst[0] == -1 and lst[1] == -1 and lst[2] == -1:
        flag = False
    # 나머지 조건에 위배되는 케이스
    if lst[0] == -1 and lst[1] != -1:
        flag = False
    if lst[1] == -1 and lst[2] != -1:
        flag = False
    if lst[1] != -1 and lst[0] > lst[1]:
        flag = False
    if lst[2] != -1 and lst[1] > lst[2]:
        flag = False

    if flag:
        ans += 1

print(ans)

