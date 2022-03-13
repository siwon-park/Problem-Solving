# N과 M(6) (15655번)
####################################################
    # 문제: https://www.acmicpc.net/problem/15655
    # 백트랙킹, 재귀
    # N과 M(5)보다 더 쉬웠던 문제다.
    # 오름차순 수열 결과를 얻기 위해 숫자 배열을 정렬했다.
    # 같은 숫자를 넣지 않기 위해 인덱스를 인자로 사용했다.
    # 맨마지막 숫자가 들어가더라도 k == M 조건을 만족시키지 못하면 출력하지 않으므로 상관없다.
####################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

def make_arr(s, k, new_arr):
    if k == M:
        print(*new_arr)
        return
    for i in range(s, N):
        make_arr(i+1, k+1, new_arr+[arr[i]])

make_arr(0, 0, [])
