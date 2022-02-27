# 색종이(10163번)
#######################################################
    # 문제: https://www.acmicpc.net/problem/10163
    # 구현
    # Python3로 53점이 나왔고, Pypy3로 통과함
    # 통과하긴했어도 시간이 꽤 걸렸고, Python3로 통과한 사람들 풀이를 대략 보니까
    # 내장함수 및 슬라이싱 쓰는게 제일 빠른듯하다?
#######################################################
import sys
input = sys.stdin.readline

N = int(input())
stack = []
board = [[0]*1001 for i in range(1001)]
for i in range(N):
    x, y, W, H = map(int, input().split())
    stack.append((x, y, W, H))

ret = []
while stack:
    x, y, W, H = stack.pop()
    cnt = 0
    for dy in range(H):
        for dx in range(W):
            if not board[y+dy][x+dx]:
                board[y+dy][x+dx] = 1
                cnt += 1
    ret.append(cnt)

while ret:
    print(ret.pop())
    
################### python 3 통과 코드(다른 사람이 짠 코드) ###################
N = int(input())
white = [[0] * 1001 for i in range(1001)]
for i in range(N):
    x, y, w, h = map(int, input().split())
    for j in range(w):
        white[x + j][y:y + h] = [i + 1] * h
for i in range(N):
    cnt = 0
    for j in range(1001):
        cnt += white[j].count(i + 1)
    print(cnt)
