# 배(1092번)
##################################################################
    # 문제: https://www.acmicpc.net/problem/1092
    # 그리디
    # 그리디 문제이지만, 사실상 완탐으로 풀었다.(Pypy3로 통과, Python3 시간초과)
    # 효율적인 풀이를 보니까, 이분탐색 및 bisect를 통해서 풀고있었다.
    # 근데 왜 저렇게 되는건지 잘 이해가 안 간다...
##################################################################
import sys
input = sys.stdin.readline

N = int(input())
C = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))

C.sort(reverse=True)
B.sort(reverse=True)

def check():
    cnt = 0
    if max(C) < max(B):
        return -1
    left = M
    while left:
        for i in range(N):
            crane = C[i]
            for j in range(left):
                box = B[j]
                if box <= crane:
                    left -= 1
                    B.pop(j)
                    break
        cnt += 1
    return cnt

print(check())

######################################################################
# 효율적인 풀이
import sys
n = int(sys.stdin.readline())
cranes = sorted(map(int, sys.stdin.readline().split()), reverse=True)
m = int(sys.stdin.readline())
boxes = sorted(map(int, sys.stdin.readline().split()), reverse=True)

if cranes[0] < boxes[0]:
    print(-1)
    exit()

def binary_search(l, r):
    def check(t):
        if n * t < m:
            return False
        for i in range(t, m, t):
            if boxes[i] > cranes[i // t]:
                return False
        return True
    while l <= r:
        mid = (l+r)//2
        if check(mid):
            ans = mid
            r = mid-1
        else:
            l = mid+1
    return ans

print(binary_search(1, m))
