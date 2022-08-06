# 진우의 민트초코우유(20208번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/20208
    # 브루트포스, 백트랙킹
    # 백트랙킹으로 구성한 순열로 매순간 체력이 음수인지 아닌지를 판별해서 먹은 민트초코 우유의 최대 개수를 구하는 문제이다.
    # 크게 막히는 부분은 없었는데, 최적화가 필요한 문제이다.
    # Python3로는 시간초과로 통과하지 못했고, Pypy3로는 통과했다.
    # Python3로 통과한 사람을 보니 한명은 for구문을 이용한 브루트포스를 사용하였고, 한명은 재귀인데 조금 더 효율적으로 구성한 것 같다.
########################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, M, H = map(int, input().split())
board = []
arr = [] # 민트초코 좌표를 담을 리스트

for i in range(N):
    board.append(input().rstrip().split())
    for j in range(N):
        if board[i][j] == "2":
            arr.append((i, j))
        elif board[i][j] == "1":
            y, x = i, j

L = len(arr)
visited = [False] * (L) # 중복방문 방지 체크 배열

# 순열을 구성하는 재귀함수
def permute(k, m, cnt, cur_y, cur_x):
    global max_cnt
    if m < 0:
        return
    if k >= 1 and m >= 0:
        if m - (abs(cur_y - y) + abs(cur_x - x)) >= 0:
            max_cnt = max(max_cnt, cnt)
    if k == L:
        return
    for i in range(L):
        if not visited[i]:
            visited[i] = True
            m -= abs(cur_y - arr[i][0]) + abs(cur_x - arr[i][1])
            if m >= 0: # 도중에 0보다 작아지면 민트초코까지 도달할 수 없음
                m += H
                cnt += 1
                permute(k+1, m, cnt, arr[i][0], arr[i][1])
                m -= H
                cnt -= 1
            m += abs(cur_y - arr[i][0]) + abs(cur_x - arr[i][1])
            visited[i] = False

max_cnt = 0
permute(0, M, 0, y, x)
print(max_cnt)

###############################################################################################
import sys
input = sys.stdin.readline

n, m, h = map(int, input().split())
mint = []
ans = 0
vt = [False for _ in range(11)]
dist = [[0] * 11 for _ in range(11)]

def brute(prev, hp, cnt) :
    for i in range(1, len(mint)) :
        if vt[i] : continue
        if hp - dist[prev][i] < 0 : continue
        vt[i] = True
        nxthp = hp - dist[prev][i] + h
        if nxthp - dist[i][0] >= 0 :
            global ans
            ans = max(ans, cnt + 1)
        brute(i, nxthp, cnt + 1)
        if ans == len(mint) - 1 : return
        vt[i] = False
    
for i in range(n) :
    row = input().split()
    for j in range(n) :
        if row[j] == '1' : mint.insert(0, (i, j))
        if row[j] == '2' : mint.append((i, j))

for i in range(len(mint)) :
    for j in range(len(mint)) :
        dist[i][j] = abs(mint[i][0] - mint[j][0]) + abs(mint[i][1] - mint[j][1])

brute(0, m, 0)
print(ans)
