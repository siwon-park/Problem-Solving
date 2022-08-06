# N과 M(5) (15654번)
########################################################
    # 문제: https://www.acmicpc.net/problem/15654
    # 백트랙킹, 재귀
    # 몇가지 잔실수 때문에 잠깐 헤맸다
    # 중복을 피하기 위해 인덱스를 안 쓰고 for 구문을 썼는데, 자꾸 중복이 들어가서 보니까 for num in new_arr를 for num in arr로 쓰고 있었다.
    # arr는 바뀌지 않으므로 계속 중복된 숫자가 들어가고 있던 셈이었다.
    # 그리고 나서도 3번째 예제에서 중복이 포함되길래 봤더니, new_arr를 arr[:]를 복사한 결과로서 재귀함수의 인자로서 넣고 있었다.
    # 이것도 nxt_new_arr라는 새로운 변수를 선언하고 new_arr의 복사형을 넣어주니까 해결되었다.
    # 아직도 재귀가 조금 많이 서툰 것 같다.
########################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

def make_arr(k, _arr, new_arr):
    if k == M:
        print(*_arr)
        return
    for num in new_arr:
        nxt_new_arr = new_arr[:]
        nxt_arr = _arr[:]
        nxt_arr.append(num)
        nxt_new_arr.remove(num)
        make_arr(k+1, nxt_arr, nxt_new_arr)

make_arr(0, [], arr)
