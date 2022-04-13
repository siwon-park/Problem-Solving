# 감소하는 수(1038번)
###########################################################
    # 문제: https://www.acmicpc.net/problem/1038
    # 백트랙킹
    # 줄어드는 수(1174번)과 같은 문제
    # 차이가 있다면 인덱스 출발 순서만 다를 뿐 문제가 완전히 같다
    # 그 차이 때문에 실수를 하나해서 인덱스 에러를 여러 번 나게했다.
    # 줄어드는 수와 다르게 0을 문자열로 넣고 시작했다면 N+1번째 위치의 수열을 뽑아야하므로
    # 결과 리스트의 길이가 N+1 이상이면 -1을 출력하게 해야한다.
###########################################################
import sys
input = sys.stdin.readline

N = int(input())
visited = [False] * 10
ret = []

def dfs(k, num):
    if k >= 2:
        if num[-2] <= num[-1]:
            return
    ret.append(int(num))
    if k == 10:
        return
    for i in range(10):
        if not visited[i]:
            visited[i] = True
            dfs(k+1, num+str(i))
            visited[i] = False

dfs(0, "0")
ret.sort()
if N + 1 >= len(ret):
    print(-1)
else:
    print(ret[N+1])
