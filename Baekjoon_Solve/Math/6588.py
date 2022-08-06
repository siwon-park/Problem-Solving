#골드 바흐의 추측(6588번)
##############################################
    # 에라토스테네스의 체 사용
    # 처음에는 에라토스테네스의 체를 사용한 뒤 소수만 모으고, 해당 소수 집합에 대하여 n-i와 i가 집합 안에 있는지 탐색하는 방법을 사용하였음
    # 그러나, 상기 방법은 시간이 오래 걸릴 수 밖에 없는게 일단 100만 이하의 소수 집합이 7~9만 개이고, n-i와 i가 있는지(if (n-i) in lst and i in lst) 확인하는 하는데 O(n)이기 때문
    # 잘 생각해보면 check배열 자체가 True나 False로 소수를 판정하는 것이고, 배열의 인덱스 접근은 O(1)이므로, 더 빠르다.
    # check[i]==True and check[n-i]==True이면 100만 이하의 소수라는 의미이니, 배열의 인덱스 접근법으로 푸는 게 더 올바른 접근법이다.
##############################################
import sys
input=sys.stdin.readline
check=[True]*(1000001)
check[0],check[1]=False,False
def find_prime():
    for i in range(2,1000001):
        if check[i]==True:
            j=2
            while i*j<=1000000:
                check[i*j]=False
                j+=1
find_prime()
while True:
    n=int(input())
    if n==0:
        break
    flag=False
    for i in range(3,n//2+1):
        if check[i] and check[n-i]: # i in check, n-i in check 처럼 탐색 없이 인덱스로만 접근
            print(str(n),"=",str(i),"+",str(n-i))
            flag=True
            break
    if not flag:
        print("Goldbach's conjecture is wrong.")
