# 색종이 만들기(2630번)
###################################################################
    # 문제: https://www.acmicpc.net/problem/2630
    # 재귀, 분할정복
    # 역시 재귀는 나한테 어렵게 느껴진다
    # 원리는 알겠고, 쪼개야하는 것도 알겠는데 어느 순간에 뭘 기준으로 합치는지 잘 모르겠다.
    # 문제 원리는 단순하다. 분할 정복해서 구간을 나눈 뒤에 for 구문을 순회하면서 파란색 블럭을 센다.
    # 그 후에 파란색 블럭의 개수가 0개라면 그 구간만큼 흰색 종이의 수를 += 1하고
    # 만약 파란색 종이의 크기가 현재 구간의 너비와 같다면 파란색 종이의 수를 +=1한다.
###################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def recur(r, c, w):
    global b_cnt, w_cnt

    cnt = 0
    # 분할 정복하여 구간을 나눠서 파란색 색종이의 수를 센다
    for i in range(r, r + w):
        for j in range(c, c + w):
            if arr[i][j]:
                cnt += 1
                
    if not cnt:
        w_cnt += 1
    elif cnt == w * w:
        b_cnt += 1
    else:
        recur(r, c, w // 2)
        recur(r + w // 2, c, w // 2)
        recur(r, c + w // 2, w // 2)
        recur(r + w // 2, c + w // 2, w // 2)
    return

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

w_cnt, b_cnt = 0, 0

recur(0, 0, N)

print(w_cnt)
print(b_cnt)

