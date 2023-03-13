import sys
input = sys.stdin.readline

N = int(input().rstrip())
K = 0
M = 0


# N이 몇 단계 moo 수열인지 찾는 함수
# n: moo 수열의 길이(S(k)), k: 단계, m: S(k - 1)의 길이
def recur(n: int, k: int) -> None:
    global K, M
    if n >= N:
        K = k
        M = (n - (k + 3)) >> 1
        return
    recur(2 * n + k + 4, k + 1)


# 재귀 호출을 통해 N번째 글자를 찾는 함수
# k 단계를 0 단계로 낮춰가면서 호출함
def recur2(n: int, m: int, k: int) -> None:
    global ans
    if k == 0:
        ans = "moo"[n - 1]
        return
    if m < n < m + k + 3:
        if n == m + 1:
            ans = "m"
        else:
            ans = "o"
    elif n <= m:
        recur2(n, (m - (k + 2)) // 2, k - 1)
    else:
        recur2(n - m - (k + 3), (m - (k + 2)) // 2, k - 1)


ans = ""
recur(3, 0)
recur2(N, M, K)
print(ans)