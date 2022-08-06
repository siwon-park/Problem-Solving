# 소수 사이 수열(3896번)
##############################################################################################
    # 문제: https://www.acmicpc.net/problem/3896
    # 에라토스테네스의 체, 이분탐색
    # 이분탐색 문제는 아니지만, 이분탐색으로 풀 수 있을 것 같아서 bisect를 사용하였다.
    # 에라토스테네스의 체를 이용해서 소수를 걸러주면서 소수일 경우에만 소수 집합에 넣고
    # 소수든 아니든, 현재 수가 몇 번째(no) 소수인지 배열에 기록해주었다.
    # 그후 입력받는 T개의 k값에 따라 k가 소수 집합에 있으면 0을 출력하고,
    # k가 합성수이면 prime[k]가 prime배열에서 왼쪽 끝, 오른쪽 끝으로 어느 인덱스에 삽입이 가능한지 구해서 그 차이값을 계산하였다.
##############################################################################################
import sys
from bisect import bisect_left, bisect_right
input = sys.stdin.readline

def is_prime():
    prime = [True] * 1299710
    only_prime = set()
    prime[0], prime[1] = False, False
    no = 0 # no번째 소수
    for i in range(1299710):
        if prime[i]:
            j = 2
            while i * j < 1299710:
                prime[i * j] = False
                j += 1
            no += 1
            prime[i] = no
            only_prime.add(i)
        else:
            prime[i] = no
    return prime, only_prime

prime, only_prime = is_prime()

T = int(input())
for tc in range(T):
    k = int(input())
    if k in only_prime:
        print(0)
    else:
        print(bisect_right(prime, prime[k]) - bisect_left(prime, prime[k]))
