# 가희와 키워드 (22233번)
##########################################################################################
    # 문제: https://www.acmicpc.net/problem/22233
    # 문자열, 집합
    # 문장을 콤마(,)로 나눈 다음에 각 문장의 문자가 키워드에 들어가 있는 것이면 키워드에서 빼주고, 이미 뺀 것이거나 없으면 차감하지 않는다.
    # 다른 사람 풀이를 보니까 생각보다 빠른 풀이 길래 봤더니 인풋을 빨리 받으면서 빼기 연산을 if문을 쓰지 않고 빨리하고 있었다.
    # set형 자료에서도 - 연산이 적용됨을 알 수 있었다.
##########################################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
cnt = N
d = dict()
for _ in range(N):
    d[input().rstrip()] = True

for _ in range(M):
    S = input().rstrip().split(",")
    for s in S:
        ret = d.get(s)
        if ret:
            d[s] = False
            cnt -= 1
    print(cnt)

################################### 다른 사람 풀이 ######################################
import sys
n, _ = map(int, input().split())
inputs = sys.stdin.read().split()
keywords = set(inputs[:n])
blogs = inputs[n:]
for blog in blogs:
    words = set(blog.split(','))
    keywords -= words # 집합형에서 바로 차감하고 있음
    print(len(keywords))
