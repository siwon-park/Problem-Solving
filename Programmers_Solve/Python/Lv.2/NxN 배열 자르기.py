# n^2배열 자르기(월간 코드 챌린지 시즌3)
##############################################
    # 잘라지는 배열의 규칙성을 찾아서 left, right만큼 자르면 됨
    # left가 있는 잘라지는 배열 인덱스는 left//n번째 배열임. 마찬가지로 right가 있는 잘라지는 배열의 인덱스는 right//n번째 배열임
    # 잘라진 배열을 구성하는 숫자의 원칙은 간단함 -> (잘라진 배열의 인덱스+1)이 (잘라진 배열의 인덱스+1)만큼 반복된 후에 잘라진 배열의 인덱스+2, +3, +4씩 증가하게되는 구조임
    # 예를들어, n=5이고 잘라진 배열의 인덱스가 2일 때, 해당 배열은 [3,3,3,4,5]임
    # 해당 규칙성 대로 부분 배열을 만드는 함수를 구현하고, 해당 부분 배열을 left인덱스(=left//n) ~ right인덱스(=right//n)까지 연결하는 함수를 구현
    # 새로 만든 연결된 배열을 자른 것을 출력하면 됨.
    # 이 때, 시작 인덱스는 left%n이고(나눈 나머지만큼 더 오른쪽으로 이동한다고 보면됨),
    # 끝 인덱스는 right에서 left를 뺀 만큼에 시작 인덱스인 left%n과 해당 숫자 인덱스까지 포함시키기 위해 +1을 하면 된다.
##############################################
def solution(n, left, right):
    def make_arr(rn):
        arr=[rn+1]*(rn+1)
        l=rn+1
        rn+=2
        while l<n:
            arr.append(rn)
            l+=1
            rn+=1
        return arr
    def concatenate_arr():
        array=[]
        for i in range(left//n,right//n+1):
            array+=make_arr(i)
        return array
    new_array=concatenate_arr()
    return new_array[left%n:right-left+left%n+1]
print(solution(3,2,5))
print(solution(4,7,14))
