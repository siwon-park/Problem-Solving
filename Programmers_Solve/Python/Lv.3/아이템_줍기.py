# 아이템 줍기(프로그래머스 위클리 챌린지 11주차)
##########################################
    # 합집합, 교집합의 개념과 BFS탐색으로 해결
    # 스케일을 2배로 늘리는게 포인트 -> 즉, x, y좌표를 +-1칸씩 보는게 아니라 +-0.5씩 보는 것이 포인트
    # 그 이유는 스케일 그대로 1칸씩 계산하면 어떤 점에서 다른 한점으로 갈 때 직접 연결이 안 되어 있는데도,
    # BFS 탐색 시 연결되어 있다고 판단해서 탐색하게 되어 잘못된 최단거리를 반환함
    # 따라서 0.5단위씩 고려해서 점들을 찾아야한다.
    # 다음으로 점들을 찾을 때, 테두리와 사각형 안의 점들을 다 포함한 좌표들의 합집합을 구하고(전체 집합)
    # 테두리를 제외한 사각형 안의 점들의 합집합을 구한다(안쪽 집합)
    # 그리고 전체 집합에서 안쪽 집합을 빼주면 바로 테두리의 좌표만 온전하게 남는다.
    # 그 다음은 출발점에서 BFS를 해서 도착점이 나오면 해당 거리를 출력하면 된다. BFS탐색 시 거리값에 1이 아니라 0.5씩 증가시켜줘야한다는 것을 역시 잊으면 안 된다. 
##########################################    
    
from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    def find_all_dots(x1,y1,x2,y2):
        all_dots=set()
        y=y1
        while y<=y2:
            x=x1
            while x<=x2:
                all_dots.add((y,x))
                x+=0.5
            y+=0.5
        return all_dots
    def find_inner_dots(x1,y1,x2,y2):
        inner_dots=set()
        y=y1+0.5
        while y<y2:
            x=x1+0.5
            while x<x2:
                inner_dots.add((y,x))
                x+=0.5
            y+=0.5
        return inner_dots
    all_d,inner_d=set(),set()
    for info in rectangle:
        x1,y1,x2,y2=info
        all=find_all_dots(x1,y1,x2,y2)
        inner=find_inner_dots(x1,y1,x2,y2)
        for y,x in all:
            all_d.add((y,x))
        for y,x in inner:
            inner_d.add((y,x))
    outer_d=all_d-inner_d
    start=(characterY,characterX,0)
    end=(itemY,itemX)
    dydx=[(-0.5,0),(0,0.5),(0.5,0),(0,-0.5)]
    q=deque([start])
    check_set={(characterY,characterX)}
    #print(outer_d,len(outer_d))
    while q:
        y,x,dist=q.popleft()
        if (y,x)==end:
            return dist
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if (ny,nx) in outer_d:
                if (ny,nx) not in check_set:
                    q.append((ny,nx,dist+0.5))
                    check_set.add((ny,nx))
    return answer
#print(solution([[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]],1,3,7,8))
#print(solution([[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]],9,7,6,1))
#print(solution([[1,1,5,7]],1,1,4,7))
