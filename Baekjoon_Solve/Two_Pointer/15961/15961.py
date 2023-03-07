import sys
input = sys.stdin.readline

N, d, k, c = map(int, input().rstrip().split())  # 접시의 수, 초밥의 수, 연속해서 먹는 수, 쿠폰 번호
sushi = []
count = [0] * (d + 1)  # 초밥 번호별 등장 횟수
for i in range(N):
    sushi.append(int(input().rstrip()))

for i in range(k):
    count[sushi[i]] += 1
    sushi.append(sushi[i])  # 원형으로 만들기 위해 k - 1개의 초밥을 추가

kind = set(sushi[:k])  # 먹을 수 있는 초밥의 종류
eat = len(kind)  # 먹을 수 있는 초밥의 개수
max_eat = eat + 1 if c not in kind else eat

e = k - 1
s = 0
while e < N + k - 1:  # e가 N + k보다 작은 동안
    count[sushi[s]] -= 1  # 현재 시작점의 초밥 등장 횟수를 감소
    if count[sushi[s]] == 0:  # 등장 횟수가 0이되면
        eat -= 1  # 먹을 수 있는 초밥의 수를 감소
    s += 1  # 시작점을 옮김
    e += 1  # 끝점을 옮김
    count[sushi[e]] += 1  # 끝점의 초밥의 등장 횟수를 증가
    if count[sushi[e]] == 1:  # 끝점의 초밥 등장 횟숙가 1이면
        eat += 1  # 먹을 수 있는 초밥의 수를 증가
    max_eat = max(max_eat, eat + 1 if count[c] == 0 else eat)

print(max_eat)