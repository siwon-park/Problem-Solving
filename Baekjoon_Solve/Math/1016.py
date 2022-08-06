#제곱 ㄴㄴ수(1016번)
#############################################
    # 문제: https://www.acmicpc.net/problem/1016
    # 에라토스테네스의 체 이용
    # 꽤나 어려운 문제여서 시간을 많이 소모했고, 결국엔 못 풀어서 다른 사람의 풀이와 힌트를 참고했다. 복습이 필요할 듯
    # 원리는 이렇다
    # i를 2부터 출발시켜 i의 제곱수(i*i)가 max_num보다 작거나 같은 동안, min_num을 i의 제곱수로 나눈 몫을 구한다.
    # 그 몫을 다시 i의 제곱수에 곱한다. (만약 min_num이 i의 제곱수로 나눠서 떨어졌다면, i의 제곱수*나눈 몫으로 다시 곱했을 땐 min_num이다.)
    # 이제 i의 제곱수*나눈 몫-min_num을 인덱스로 하여 해당 인덱스에 있는 값이 True면 False로 바꾸고 count+=1을 한다. 이는 min_num+인덱스 값이 해당 제곱수로 나누어 떨어진다는 의미이다.
    # (이때 인덱스가 반드시 0보다 크다라는 조건이 있어야하는데, 왜냐하면 i의 제곱수 값이 min_num보다 커지면, 나눈 몫이 0이기 때문에, 인덱스가 음수로 나오고
    # 해당 음수 인덱스로 접근하여 check 배열을 바꿀 수도 있으므로, 잘못된 답을 출력하게 된다.)
    # 배열의 0번째 인덱스를 min_num에 대한 것으로 보는 것이다.
    # 인덱스에 False를 체크해준뒤, 해당 while 구문 내에서 나눈 몫에 +=1을 해주면서 i의 제곱수*나눈 몫이 max_num보다 작거나 같은 동안 반복한다.
    # 예를 들어 33는 4(제곱수)로 나눈 몫이 8이고, 제곱수로 나누어 떨어지지 않는다. 4*8-33은 -1이므로 인덱스에 접근할 수 없다. 그런데, 여기서 몫인 8에 1을 더한 9로 했을 때,
    # 4*9는 33보다 크고, 나누어 떨어지는 숫자이다. 따라서 0번째 인덱스를 33이라고 했을 때, 36-33=3이므로, 배열의 3번째 인덱스에 나누어 떨어진다고 False로 체크하는 것이다.
#############################################
import sys,math
input=sys.stdin.readline
min_num,max_num=map(int,input().split())
check=[True]*(max_num-min_num+1)
count=0
i=2
while i**2<=max_num:
    sqrt=i**2
    quot=min_num//sqrt
    while sqrt*quot<=max_num:
        indx=sqrt*quot-min_num
        if indx>=0:
            if check[indx]:
                count+=1
                check[indx]=False
        quot+=1
    i+=1
print(max_num-min_num-count+1)
