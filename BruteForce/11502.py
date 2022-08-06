# 세 개의 소수 문제(11502번)
####################################################################################
    # 문제: https://www.acmicpc.net/problem/11502
    # 소수, 에라토스테네스의 체, 브루트포스
    # 에라토스테네스의 체로 1000이하의 소수를 구한 다음
    # 브루트포스를 통해 3개의 조합을 찾아 합이 K가 되는 수를 오름차순으로 하나만 출력하면 된다.
    # 풀이가 빠른 편이 아닌데, 어디서 비효율이 발생했는지 잘 모르겠다...
####################################################################################
import sys
input = sys.stdin.readline

is_prime = [True] * 1001
is_prime[0], is_prime[1] = False, False
prime = []
for i in range(2, 1001):
    if is_prime[i]:
        j = 2
        while i * j <= 1000:
            is_prime[i * j] = False
            j += 1
        prime.append(i)

N = len(prime)

def find(K):
    ans = []
    for i in range(N):
        if prime[i] >= K:
            break
        n1 = prime[i]
        for j in range(N):
            if prime[j] >= K:
                break
            n2 = prime[j]
            for k in range(N):
                if prime[k] >= K:
                    break
                n3 = prime[k]
                if n1 + n2 + n3 == K:
                    ans.append(n1)
                    ans.append(n2)
                    ans.append(n3)
                    ans.sort()
                    return ans
    return ans

T = int(input())
for tc in range(T):
    K = int(input())
    ans = find(K)
    if ans:
        print(*ans)
    else:
        print(0)
