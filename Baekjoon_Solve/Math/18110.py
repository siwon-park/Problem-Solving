# solved.ac(18110번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/18110
    # 수학, 정렬
    # round 함수가 반올림을 해줄 때 우리가 의도한대로 작동하지 않는 경우 있는데, 이 문제에서 그러한 경우가 발생한 듯하다.
    # 그래서 정수연산만으로 구현을 해보았다.
    # 리스트를 정렬한 뒤에 앞 뒤로 전체의 15%를 반올림한 수만큼 잘라서 평균을 구한 뒤 해당 평균에 대해서도 똑같은 방법으로 반올림해준다. 
#####################################################################################
import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))
if n == 0:
    print(0)
else:
    arr.sort()
    l = n * 0.15
    l *= 10
    if l % 10 >= 5:
        l = int(l/10) + 1
    else:
        l = int(l/10)
    arr = arr[l:len(arr)-l]
    if len(arr):
        avg = sum(arr)/len(arr)
        if (avg * 10) % 10 >= 5:
            print(int(avg) + 1)
        else:
            print(int(avg))
    else:
        print(0)
