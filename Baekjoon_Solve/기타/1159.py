# 농구 경기(1159번)
###########################################################################################
    # 문제: https://www.acmicpc.net/problem/1159
    # 딕셔너리를 활용한 문자열 문제
    # 각 문자열의 앞 글자를 키값으로 하여 딕셔너리에 담고 앞 글자가 몇 번 등장했는지를 값으로 저장한다.
    # 딕셔너리를 순회하여 값이 5 이상인 문자열에 대해 결과 배열에 담고 정렬한 뒤에 문자열 형태로 출력하였다.
###########################################################################################
import sys
input = sys.stdin.readline

N = int(input())
name_dict = dict()

for _ in range(N):
    S = input().rstrip()
    name_dict[S[0]] = name_dict.get(S[0], 0) + 1

result = []
for k in list(name_dict.keys()):
    if name_dict[k] >= 5:
        result.append(k)

if not result:
    print("PREDAJA")
else:
    result.sort()
    print("".join(result))
