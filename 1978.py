#소수 찾기(1987번)
#############################################
    # 문제: https://www.acmicpc.net/problem/1978
    # 에라토스테네스의 체 사용
    # 일단 모든 수는 소수다(True)라고 가정하고, 0과 1에 대해서는 False로 처리하여 시작
    # 2부터 탐색을 시작하여, 해당 수에 j(단, j>=2)를 곱한 수를 check 배열에서 False로 처리해줌
#############################################
import sys
input=sys.stdin.readline
N=int(input())
nums=list(map(int,input().split()))
check=[True]*1001
check[0],check[1]=False,False
for i in range(2,1001):
    if check[i]==True:
        j=2
        while i*j<=1000:
            check[i*j]=False
            j+=1
count=0
for num in nums:
    if check[num]:
        count+=1
print(count)
