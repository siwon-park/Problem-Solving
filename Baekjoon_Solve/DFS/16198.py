# 에너지 모으기(16198번)
########################################################################
    # 문제: https://www.acmicpc.net/problem/16198
    # DFS, 백트랙킹
    # 백트랙킹 연습용으로 풀었음
    # 처음에 E += arr[x-1]*arr[x+1] 줄과 num = arr.pop(x)의 줄을 바꿔썼는데 인덱스 오류가 났었음
    # 그래서 약간 이해가 안됐으나, 생각해보니까 x-1, x+1에 있는 값들을 곱해줘야하니까, x가 먼저 빠지면 당연히 인덱스 오류가 나는 것이었다.
########################################################################
import sys
input = sys.stdin.readline

N = int(input())
W = list(map(int, input().split()))

def back_tracking(E, arr):
    global max_E
    if len(arr) == 2:
        max_E = max(max_E, E)
        return
    for x in range(1, len(arr)-1):
        E += arr[x-1]*arr[x+1]
        num = arr.pop(x)
        back_tracking(E, arr)
        arr.insert(x, num)
        E -= arr[x-1]*arr[x+1]

max_E = 0
back_tracking(0, W)
print(max_E)
