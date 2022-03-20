# 이진 검색 트리(5639번)
####################################################################
    # 문제: https://www.acmicpc.net/problem/5639
    # 트리, 재귀
    # 내가 처음 생각했던 풀이가 왜 틀렸는지 아직도 모르겠음(시간초과 여부를 떠나 1%에서 틀렸습니다가 나오는데, 이유를 못찾겠다)
    # 처음 풀이는 전위순회결과를 알고있으니까 그에 맞는 트리를 만들고 후위순회를 하는 것인데,
    # 물론 노드 수가 10000개여서 최대 높이를 가정한다면 1만 크기의 배열로는 턱도 없이 모자란 걸 알지만
    # 그래도 1%에서 틀렸습니다가 나오는게 이해되지 않는다.
    # 아무튼 그래서 그냥 어차피 전위 순회 결과의 첫번째는 항상 부모 노드(루트 노드)이다. 결과가 VLR의 구조를 뛰므로,
    # LRV구조를 띄도록 재귀적으로 바꿔주면 된다.
####################################################################
import sys
input = sys.stdin.readline
sys.setrecursionlimit(int(1e6))

def make_post_order(arr):
    N = len(arr)
    if not arr:
        return []
    if N == 1:
        return [arr[0]]
    for i in range(1, N):
        if arr[i] > arr[0]:
            return make_post_order(arr[1:i]) + make_post_order(arr[i:]) + [arr[0]]    
    return make_post_order(arr[1:]) + [arr[0]]
'''
아래 코드는 비록 직관적이긴 하지만, 시간초과가 나는 이유는 for 내포 구문에서 새로운 배열을 만들 때 어찌됐든 그 배열의 크기만큼까지 탐색을
해야하기 때문에 통과한 코드보다 더 오래걸릴 수 밖에 없음. 이진 탐색 트리이기 때문에 전회순위 결과 어느 시점 이후로는 루트보다 큰 값만 나오기
때문에 사실상 그 이후로 탐색하지 않고 바로 재귀를 돌려야하나 끝까지 탐색해서 배열 만들고 재귀를 돌으므로 상대적으로 더 걸릴 수 밖에 없다.
def make_post_order(i, arr):
    if not arr:
        return []
    return make_post_order(i, [x for x in arr if x < arr[i]]) + make_post_order(i, [x for x in arr if x > arr[i]]) + [arr[i]]
'''

preorder_ret = []
while True:
    try:
        preorder_ret.append(int(input()))
    except:
        break

post_order = make_post_order(preorder_ret)

for num in post_order:
    print(num)
