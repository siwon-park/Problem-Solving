#2021은 무엇이 특별할까?(24039번)
#################################################
    # 문제: https://www.acmicpc.net/problem/24039
    # 에라토스테네스의 체, 소수 판정
    # 에라토스테네스의 체를 통해 소수를 구하고
    # 해당 소수의 2연속 곱이 N보다 커지면 출력하고 break함
#################################################
import sys
input=sys.stdin.readline
check=[True]*1001
check[0],check[1]=False,False
prime=[]
for i in range(2,1001):
    if check[i]:
        prime.append(i)
        j=2
        while j*i<=1000:
            check[i*j]=False
            j+=1
N=int(input())
for i in range(len(prime)-1):
    if prime[i]*prime[i+1]>N:
        print(prime[i]*prime[i+1])
        break
