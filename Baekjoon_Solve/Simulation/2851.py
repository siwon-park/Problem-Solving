# 슈퍼 마리오(2851번)
###################################################
    # 문제: https://www.acmicpc.net/problem/2851
    # 수학, 구현
    # 매우 간단한 문제. 빈 배열을 만들고, (누적합+현재 버섯의 값이) >= 100이면 (누적합, 누적합+현재 버섯의 값)을 리스트에 넣어준다. 누적합은 그 이후에 +현재 버섯의 값하여 갱신함
    # 리스트가 비어있으면 버섯을 10개 먹었는데도 100이 안 되었다는 의미이므로, 바로 누적합을 출력하면 된다.
    # 그게 아니라면, 리스트의 0번째 인덱스에 있는 값이 100과 가장 가까운 최소, 최대값들이 들어 있으므로 최댓값, 최솟값 중 100과 더 가까운 값을 출력한다. 만약 같다면 최댓값을 출력함
###################################################
import sys
input=sys.stdin.readline
total=0
result=[]
for _ in range(10):
    mush=int(input())
    if total+mush>=100:
        result.append((total,total+mush))
    total+=mush

if not result:
    print(total)
else:
    min_value,max_value=result[0]
    ab_min_v,ab_max_v=abs(100-min_value), abs(100-max_value)
    if ab_max_v<=ab_min_v:
        print(max_value)
    else:
        print(min_value)
