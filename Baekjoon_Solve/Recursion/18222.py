# 투에-모스 문자열 (18222번)
"""
  문제: https://www.acmicpc.net/problem/18222
  분할정복, 재귀
  투에-모스 문자열의 규칙성은 다음과 같다.
  투에-모스 문자열의 길이는 2^n이다. (n >= 0)
  k를 입력받았을 때, k <= 2^n 를 만족하는 2^n을 찾아서
  절반씩 분할정복하면서 재귀 호출을 하면 된다. 이 때, k가 투에-모스 문자열의 길의의 절반보다 크면
  0과 1이 반전된 상태이다. 이를 표시하기 위해 매개 변수로 s를 사용하였고 양수라면 정상, 음수라면 반전 상태이다.
  k가 1일 때, 정상 상태이면 0을, 반전 상태이면 1을 출력하면 된다.
"""
import sys
input = sys.stdin.readline


def recur(k: int, n: int, s: int) -> None:
    global ans
    if k <= 1:
        if s > 0:
            ans = 0
        else:
            ans = 1
        return
    if k > n // 2:
        recur(k - n // 2, n // 2, s * -1)
    else:
        recur(k, n // 2, s)


ans = 0
K = int(input().rstrip())
N = 1
while N < K:
    N *= 2

recur(K, N, 1)

print(ans)
