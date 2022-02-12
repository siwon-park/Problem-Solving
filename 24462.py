# 일어나... 코딩해야지...(24462번)
##################################################################
    # 문제: https://www.acmicpc.net/problem/24462
    # 수학, 정수론, 브루트 포스
    # 브루트 포스 알고리즘을 사용했지만, 간단한 수학적 스킬이 더 필요했던 문제
    # 처음에 너무 안 풀렸었는데, 결국 해냈고 별 것 아닌 부분에서 엄청 시간을 잡아먹혔다.
    # 각 각 두 알람이 울린 횟수에서 두 알람이 공통적으로 중복된 부분을 뺀 알람 횟수와, 그 때 각 알람 번호를 구하는 문제
    # 문제를 거의 다 풀어놓고 자꾸 시간초과가 나왔었는데, 생각해보니 t부터 D+1까지 for 반복 구문을 해줄 필요가 없었다.
    # 어차피 반복 구문 돌면서 cnt-=1을 하는데, 굳이 반복 구문 돌 필요없이 반복 구문 돌만큼의 숫자를 한번에 빼주면 됐는데, 엄청난 실수였다.(심지어 몰랐음)
    # t를 구하는 것도 약간 생각이 필요했었다.
##################################################################
import sys
input = sys.stdin.readline

N, D = map(int, input().split())

lst = []
for i in range(N):
    T, K = map(int, input().split())
    lst.append((int((D-T)/K)+1, T, K)) # 알람 울린 횟수, 알람 시작 시간, 스누즈 시간

# 최대 공약수
def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

# 최소 공배수
def lcm(a, b):
    return a * b // gcd(a, b)

def find():
    max_cnt = 0
    for i in range(N):
        for j in range(i+1,N):
            t = max(lst[i][1], lst[j][1])
            k = lcm(lst[i][2], lst[j][2])
            cnt = lst[i][0] + lst[j][0]
            if t % k == 0:
                t = (t//k)*k
            else:
                t = (t//k+1)*k
            # for al in range(t, D+1, k):
            #     cnt -= 1
            cnt -= (D-t)//k+1
            if cnt > max_cnt:
                max_cnt = cnt
                comb = (i+1, j+1)
    return comb, max_cnt
res = find()
print(*res[0])
print(res[1])
