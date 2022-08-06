# 리모컨(1107번)
############################################################################
    # 문제: https://www.acmicpc.net/problem/1107
    # 브루트포스 알고리즘
    # 버튼을 누르는 최소 횟수의 초깃값은 abs(N - 100)의 값이다(현재 채널이 100이니)
    # 그 후 DFS로 L+1자리까지의 숫자를 모두 구하면서 버튼을 누르는 최소 횟수를 갱신해주는 작업을 하였다.
    # L+1자리까지 구하는 이유는 예를 들어, 목표 채널이 999번인데 0과 1번만 고장나지 않았다면 1000을 만들고 -를 눌러야하는 경우가 최소이기 때문이다.
    # 처음에 int(s)가 N과 일치하는 경우 버튼을 누르는 최소횟수를 갱신하는데 있어 실수가 있었다.(주석 참조)
    # 그리고 Python3로 채점을 하니 66%에서 시간초과가 나왔다. 아마 무작정 L+1자리까지 구했기 때문인 것 같다.
    # Pypy3로는 2480ms로 느린 속도로 통과할 수 있었다. 그래서 중간에 가지치기를 해서 return할 수 있는 방법이 없나 생각해봤더니
    # L+1의 자리를 구할 때 L+1자리인 모든 수를 구할 필요가 없었다. 왜냐하면 L+1이면서 목표 채널과 가장 가까운 채널만 구하면 됬기 때문이다.
    # 그래서 if k > L+1 부분을 if k >= L+1 and abs(N - int(s))+k > min_cnt로 바꾸니까 Pypy3 기준으로 거의 3배 가량 빠른 속도인 860ms로 통과할 수 있었다.
    # 훨씬 빠른 속도로 푼 사람들이 많아서 만족할만한 풀이는 아니지만, 그래도 풀었다는 것과 비효율적인 부분을 찾아서 시간을 많이 줄일 수 있었다는 것에 의의를 둔다.
############################################################################
import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
L = len(str(N))

available = list(range(10))
if M != 0:
    broken = list(map(int, input().split()))
    for i in range(M):
        available.remove(broken[i])

min_cnt = sys.maxsize

def dfs(k, s): # k는 버튼을 누르는 횟수임
    global min_cnt
    if k >= L+1 and abs(N - int(s))+k > min_cnt: # 처음에 K > L+1로만 했더니 시간 소모 많았음
        return
    if int(s) == N:
        min_cnt = min(min_cnt, k) # 처음에 min_cnt = k로 했더니 반례 존재 → 101일 경우 3을 출력했음
        return
    min_cnt = min(abs(N - int(s))+k, min_cnt)
    for num in available:
        dfs(k+1, s+str(num))

def find(cur):
    global min_cnt
    if cur == N:
        min_cnt = 0
        return min_cnt
    # +나 -를 해봄
    min_cnt = min(abs(N - cur), min_cnt)
    
    # N+1자리수까지 숫자를 만들어서 카운트해봄
    if available:
        for n in available:
            dfs(1, str(n))
    return min_cnt

print(find(100))
