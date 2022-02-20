# 제곱근(13706번)
########################################################
    # 문제: https://www.acmicpc.net/problem/13706
    # 수학, 이분탐색
    # Recursion Error가 두 번 났었음. 처음엔 sys.setrecursionlimit을 설정 안 해줬었고, 두번째는 설정했는데 보니까 잘못설정해줬음
    # N의 자리수가 최대 800자리이므로 연산하면서 int를 쓰면 안 된다.
########################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())

def binary_search(s, e, target):
    if s > e:
        return None
    m = (s + e) // 2
    if m**2 == target:
        return m
    elif m**2 < target:
        return binary_search(m+1, e, target)
    else:
        return binary_search(s, m-1, target)

print(binary_search(1, N//2+1, N))
