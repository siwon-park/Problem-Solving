# 데뷔의 꿈(24465번)
####################################################
    # 문제: https://www.acmicpc.net/problem/24465
    # 구현, 정렬
    # 정렬하는 이유는 출력 순서 때문임
    # 나의 구현 방법: 일에 해당하는 숫자를 100으로 나눠 소숫점 둘째자리 숫자를 만들었고 해당 구간 안에 포함되었을 경우
    # count배열의 값을 증가시켜주는 함수를 하나 만들었고, 이 함수와 비슷하게 count배열에 숫자가 없으면 후보자 리스트에 append시켜주는 함수를 만듦
    # 아이디어 자체는 틀린 부분이 없으나, 코드가 너무 길어졌다는 단점이 있음
    # 하단에 bisect를 이용한 방법이 훨씬 더 간결하고 좋은 아이디어의 방법인 듯하다.
####################################################
import sys
input = sys.stdin.readline

def check1(b_day):
    if 1.20 <= b_day <= 2.18:
        count[0] += 1
    elif 2.19 <= b_day <= 3.20:
        count[1] += 1
    elif 3.21 <= b_day <= 4.19:
        count[2] += 1
    elif 4.20 <= b_day <= 5.20:
        count[3] += 1
    elif 5.21 <= b_day <= 6.21:
        count[4] += 1
    elif 6.22 <= b_day <= 7.22:
        count[5] += 1
    elif 7.23 <= b_day <= 8.22:
        count[6] += 1
    elif 8.23 <= b_day <= 9.22:
        count[7] += 1
    elif 9.23 <= b_day <= 10.22:
        count[8] += 1
    elif 10.23 <= b_day <= 11.22:
        count[9] += 1
    elif 11.23 <= b_day <= 12.21:
        count[10] += 1
    else:
        count[11] += 1

count = [0]*12
for i in range(7):
    M, D = map(int, input().split())
    D /= 100
    check1(M+D)

N = int(input())
lst = []
for i in range(N):
    m, d =map(int, input().split())
    lst.append((m, d))
cand = []
for m, d in lst:
    b_day = m + d / 100
    if 1.20 <= b_day <= 2.18:
        if not count[0]:
            cand.append((m,d))
    elif 2.19 <= b_day <= 3.20:
        if not count[1]:
            cand.append((m,d))
    elif 3.21 <= b_day <= 4.19:
        if not count[2]:
            cand.append((m,d))
    elif 4.20 <= b_day <= 5.20:
        if not count[3]:
            cand.append((m,d))
    elif 5.21 <= b_day <= 6.21:
        if not count[4]:
            cand.append((m,d))
    elif 6.22 <= b_day <= 7.22:
        if not count[5]:
            cand.append((m,d))
    elif 7.23 <= b_day <= 8.22:
        if not count[6]:
            cand.append((m,d))
    elif 8.23 <= b_day <= 9.22:
        if not count[7]:
            cand.append((m,d))
    elif 9.23 <= b_day <= 10.22:
        if not count[8]:
            cand.append((m,d))
    elif 10.23 <= b_day <= 11.22:
        if not count[9]:
            cand.append((m,d))
    elif 11.23 <= b_day <= 12.21:
        if not count[10]:
            cand.append((m,d))
    else:
        if not count[11]:
            cand.append((m,d))
cand.sort()
if not cand:
    print("ALL FAILED")
else:
    for b_day in cand:
        print(*b_day)
        
########################################################################################
# bisect를 활용한 풀이법
# 해설: 튜플 형태의 day를 zodiac함수에 넣었을 때, 배열의 순서를 유지하면서 해당 요소를 삽입할 수 있는 가장 오른쪽 위치를 반환함
# 반환한 위치 인덱스를 member리스트에 저장함
# 후보자의 생일을 zodiac함수에 넣었을 때 반환된 인덱스가 member리스트에 없다면 ans리스트에 저장하고
# ans리스트에 요소가 없으면 "ALL FAILED"를, 하나라도 있으면 ans리스트를 정렬하여 해당 요소를 오름차순으로 출력함
import sys
from bisect import bisect

def zodiac(day):
    arr = [
        (1, 20),
        (2, 19),
        (3, 21),
        (4, 20),
        (5, 21),
        (6, 22),
        (7, 23),
        (8, 23),
        (9, 23),
        (10, 23),
        (11, 23),
        (12, 22),
    ]
    i = bisect(arr, day)
    return i % 12

member = [zodiac(tuple(map(int, input().split()))) for _ in range(7)]
input()
ans = []
for line in sys.stdin:
    day = tuple(map(int, line.split()))
    if zodiac(day) not in member:
        ans.append(day)

if ans:
    for a in sorted(ans):
        print(*a)
else:
    print("ALL FAILED")  
