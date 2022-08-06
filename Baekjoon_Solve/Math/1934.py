#최소 공배수(1934번)
##########################################
    # 최소 공배수, 최대 공약수 소스 코드 기록용
    # 최대 공약수(GCD)
    #def gcd(A,B):
    #    while B != 0:
    #       t = A%B
    #       (A,B) = (B,t)
    #    return abs(A)
    
    # 최소 공배수(LCM)
    #def lcm(A,B):
    #    gcd=gcd(A,B) #gcd=math.gcd(A,B)
    #    return (A//gcd)*(B//gcd)*gcd       
##########################################
import sys,math
input=sys.stdin.readline
T=int(input())
for i in range(T):
    A,B=map(int,input().split())
    gcd=math.gcd(A,B)
    lcm=(A//gcd)*(B//gcd)*gcd
    print(lcm)
