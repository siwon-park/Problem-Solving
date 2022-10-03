# 찾기 (1786번)
############################################################################################
    # 문제: https://www.acmicpc.net/problem/1786
    # 문자열, KMP
    # kmp에 대해 배우고 적용하기 위해 푼 문제
    # 문제에서는 kmp의 과정에 대해 설명하고 있고, 이를 적용해서 풀면된다.
    # 다만 주의해야할 점이 있다면 문자열을 1부터 셌기 때문에, 패턴 매칭이 일치하는 시작 인덱스에 +1을 해줘야한다.
    # 그래서 만약 i가 0부터 문자열을 셌다면 ret.append(i - M + 1)이겠지만, 1부터 시작했기 때문에 ret.append(i - M + 2)이다.
    # 그리고 엄밀히 말해서 일치하는 패턴의 개수를 출력하고, 그 시작 인덱스를 출력해야하니까
    # 만약 일치하는 패턴이 없다면 0만 출력하고, 있을 경우에만 인덱스들을 출력하는 게 맞지 않나 싶다.
    # 아마 문제에서 들어오는 입력들이 최소 1개는 있는 케이스거나, 0과 그 다음 칸에 공백을 출력하는 것도 정답으로 인정해주는 것일 수도 있겠다.
############################################################################################
import sys
input = sys.stdin.readline

# 실패 함수
def find_fail(p):
    fail = [0] * M
    j = 0

    for i in range(1, M):
        while j > 0 and p[i] != p[j]:
            j = fail[j - 1]

        if p[i] == p[j]:
            j += 1
            fail[i] = j

    return fail

# KMP
def kmp(t, p):
    ret = []
    j = 0
    fail = find_fail(p)

    for i in range(N):
        while j > 0 and t[i] != p[j]:
            j = fail[j - 1]

        if t[i] == p[j]:
            if j == M - 1:
                ret.append(i - M + 2) # 원래 i - M + 1인데 1을 더하는 이유: 문제에서 1부터 문자를 카운트함
                j = fail[j]
            else:
                j += 1

    return ret

T = input().rstrip()
P = input().rstrip()

N = len(T)
M = len(P)

result = kmp(T, P)

print(len(result))
print(*result)
