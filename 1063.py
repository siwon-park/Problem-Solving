#킹(1063번)
###############################################
    # 킹과 돌의 좌표를 입력 받아서 해당 좌표들을 알맞은 형태의 배열 좌표로 변환시키면 해결
    # 예) x축: A -> 0, D -> 3  // y축: 1 -> 7 (=8-1), 5 -> 3 (=8-5)
    # 킹을 움직였을 때, 그 위치에 돌이 있으면 돌을 킹이 움직인 방향과 똑같이 움직여준다.
    # 해당 위치에 돌이 없다면 킹만 움직인다.
###############################################
import sys
input=sys.stdin.readline
cols="ABCDEFGH"
dirs={"R":(0,1), "L":(0,-1), "B":(1,0), "T":(-1,0), "RT":(-1,1), "LT":(-1,-1), "RB":(1,1), "LB":(1,-1)}
king,rock,N=input().split()
ky,kx=8-int(king[1]),cols.index(king[0])
ry,rx=8-int(rock[1]),cols.index(rock[0])
for i in range(int(N)):
    dy,dx=dirs[input().rstrip()]
    nky,nkx=ky+dy,kx+dx
    nry,nrx=ry+dy,rx+dx
    if 0<=nky<8 and 0<=nkx<8:
        if (nky,nkx)==(ry,rx):
            if 0<=nry<8 and 0<=nrx<8:
                ry,rx=nry,nrx
                ky,kx=nky,nkx
        else:
            ky,kx=nky,nkx
print(cols[kx]+str(8-ky))
print(cols[rx]+str(8-ry))
