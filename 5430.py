#AC(5430번)
############################################
    # 큐 사용
    # 첫 시도 시간초과, 두번째 시도 틀렸습니다.
    # 시간초과 난 이유는 arr를 리스트형태로 선언하고 명령어가 R일때 마다 [::-1]로 직접 뒤바꿨는데,
    # 생각해보니 그럴 필요 없었고 R이 나온 횟수에 따라 D가 나왔을 때, 맨 앞의 숫자를 빼줄 것인지, 맨 뒤의 숫자를 빼줄 것인지만 선택하면 되는 것이었음
    # "틀렸습니다"가 나온 이유는 빈 배열([])일 경우 무조건 error가 아니고,
    # 빈 배열일 때 R이 나오면 에러가 아니라 뒤집어도 그대로 []이고, D인데 배열이 비었을 경우에만 뺄 숫자가 없으니 error를 출력해야하는 것이었음
    # 예를 들어, T=2, (p=D, n=0, []), (p=R, n=0, []) 일 때, 순서대로 error와 []를 출력해야함
############################################
import sys
from collections import deque
input=sys.stdin.readline
T=int(input())
for _ in range(T):
    p=deque(list(input().rstrip()))
    n=int(input())
    arr=deque(input().rstrip()[1:-1].split(","))
    flag=True
    R_count=0
    while p:
        cmd=p.popleft()
        if cmd=="R":
            R_count+=1
        elif cmd=="D": #명령어가 "D"인데 배열이 비었을 경우에만 error임
            if not arr or n==0:
                flag=False
                break
            if R_count%2==0:
                arr.popleft()
            else:
                arr.pop()
    if not flag:
        print("error")
    else:
        arr=list(arr)
        if R_count%2!=0:
            arr=arr[::-1]
        print("["+",".join(arr)+"]")
