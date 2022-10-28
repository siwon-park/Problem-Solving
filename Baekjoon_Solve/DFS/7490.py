# 0 만들기 (7490번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/7490
    # 백트랙킹, 브루트포스
    # +, -일 때는 문제가 없었는데, " "(공백)일 때가 문제였다.
    # 처음엔 단순히 직전 숫자에 10을 곱하는 방식으로 생각했는데, 만약 공백이 연속으로 이어진다면 10을 곱해서는 끝이 나지 않는다.
    # 그래서 생각해 낸 것이 직전 숫자 합과 임시 합인 last와 tmp였고,
    # 공백으로 연결시킬 때는 합에서 last를 뺀 다음에 tmp 값(last에 10을 곱한 다음 k + 1을 연산해준 값)을 더해주었다.
    # 그리고 매번 DFS를 돌려서 N 마다 0이 되는 연산식을 구한 것이 아니라, 3부터 9까지 DFS를 돌린 다음 배열에 각 숫자별로 0이 되는 연산을 넣었다.
    # 그 다음 해당 배열을 정렬하여(아스키II 순서로 출력하기 위함), 각 테스트 케이스별로 주어지는 N에 대해 배열의 N번째 인덱스에 존재하는 연산식들을 출력하였다.
    # 크게 어려운 문제는 아니었는데, 아이디어를 생각해내기까지 조금 시간이 걸렸던 문제이다.
    # 주의할 점은 테스트 케이스별로 개행문자를 출력해야한다.
###################################################################################
import sys
input = sys.stdin.readline

ret = [[] for _ in range(10)] # 결과를 담을 배열

def dfs(k, cur, res, last):
    global i
    if k == i:
        if res == 0:
            ret[i].append(cur)
        return
    dfs(k + 1, cur + "+" + str(k + 1), res + (k + 1), k + 1)
    dfs(k + 1, cur + "-" + str(k + 1), res - (k + 1), -(k + 1))
    if last < 0:
        tmp = last * 10 - (k + 1)
    else:
        tmp = last * 10 + (k + 1)
    dfs(k + 1, cur + " " + str(k + 1), res - last + tmp, tmp)

for i in range(3, 10):
    dfs(1, "1", 1, 1)
    if ret[i]:
        ret[i].sort()

T = int(input().rstrip())
for _ in range(T):
    N = int(input().rstrip())
    for k in range(len(ret[N])):
        print(ret[N][k])
    print()
