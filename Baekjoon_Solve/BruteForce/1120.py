#문자열(1120번)
####################################################
    # 완전탐색 이용
    # A의 시작이나 끝에 아무 문자를 붙일 수 있다고 했으므로, 사실상 B를 A의 길이만큼 슬라이싱한 문자열과 비교를 하면 됨
    # 빈 배열을 2개 선언한다. 한개는 B를 A의 길이만큼 자른 문자열을 담고, 다른 한개는 해당 문자열과 A를 비교해서 불일치하는 개수를 담는다.
    # A와 불일치하는 문자의 수가 담긴 배열의 최솟값을 반환하면 끝.
####################################################
import sys
input=sys.stdin.readline
A,B=input().split()
n1=len(A)
n2=len(B)
def make_new_string(B,i,n):
    return B[i:i+n]
news=[]
if n2-n1!=0:
    for i in range(n2-n1+1):
        news.append(make_new_string(B,i,n1))
else:
    news.append(B)
def compare(A,n_B,n):
    count=0
    for i in range(n):
        if A[i]!=n_B[i]:
            count+=1
    return count
result=[]
for new in news:
    result.append(compare(A,new,n1))
print(min(result))
