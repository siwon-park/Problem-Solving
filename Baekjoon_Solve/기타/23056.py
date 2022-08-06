# 참가자 명단(23056번)
############################################################################################
    # 문제: https://www.acmicpc.net/problem/23056
    # 정렬
    # 조건에 맞게 리스트에 담는 것까진 했는데, 어떻게 홀수를 먼저 정렬할 수 있을까 생각해보니
    # 홀수든 짝수든 2로 나누면 0이나 1이므로 이를 기준으로 정렬할 수 있었다.
############################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, M = map(int, input().split())
lst = []
cls_dict = dict()
while True:
    cls, name = input().rstrip().split()
    if cls == "0" and name == "0":
        break
    cls = int(cls)
    cls_dict[cls] = cls_dict.get(cls, 0) + 1
    if cls_dict[cls] <= M:
        lst.append((cls%2, cls, name)) # 홀수를 먼저 출력하기 위해 cls를 2로 나눈 나머지를 요소로 넣음

# 홀수를 먼저, 짝수를 나중에
# 학급을 오름차순 정렬
# 이름의 길이가 짧은 순으로, 길이가 같다면 사전순으로 빠른 순
lst.sort(key=lambda x: (-x[0] , x[1], len(x[2]), x[2]))
for i in range(len(lst)):
    print(lst[i][1], lst[i][2])
