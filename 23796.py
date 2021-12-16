#2,147,483,648게임(23796번)
#################################################
    # 문제: https://www.acmicpc.net/problem/23796
    # 구현
    # 주어진 조건에 맞게 board의 숫자를 움직이면 된다.
    # 조건 2가 조금 헷갈렸는데,
    # "밀어넣는 방향으로 같은 수가 두 타일 연속해서 존재한다면 그 두 타일을 합친다." == "세 타일 이상 연속해있다면 방향키가 가리키는 쪽의 벽에 가까운 쪽부터 두 개씩 합쳐진다."
    # 주어진 방향으로 한칸 씩 옮기는 방식으로 구현한다 했을 때, 위의 두 문장은 사실 같은 말이다.
    # 예를 들어, 방향이 L이고 256 256 256 256 0 0 0 0이 있을 때, 앞 문장대로 하나, 뒷 문장대로 하나 512 512 0 0 0 0 0 0으로 결과가 나온다.
    # 3번째 조건은 board와 크기가 같은 check 배열을 만들어서 False일 경우에만 합치고, 이미 타일이 합쳐졌으면 해당 위치를 True로 바꿈으로 써, 두 번 이상 바뀌지 않게 구현하였음
    # 방향이 L 또는 U일 경우와 R 또는 D일 경우, 각 각 같은 방향으로 for 구문을 탐색하는 데, 각 경우 마다 for 구문을 쓰는 것보다
    # s,e,k라는 변수를 선언해서 for 구문을 또 쓰는 것을 방지하였음
#################################################
import sys
input=sys.stdin.readline
board=[]
for _ in range(8):
    board.append(list(map(int,input().split())))
direction=input().rstrip()
dydx={"U":(-1,0),"R":(0,1),"D":(1,0),"L":(0,-1)}
def move_board(direction):
    dy,dx=dydx[direction]
    check=[[False]*8 for i in range(8)]
    if direction=="L" or direction=="U":
        s,e,k=0,8,1
    elif direction=="R" or direction=="D":
        s,e,k=7,-1,-1
    for y in range(s,e,k):
        for x in range(s,e,k):
            if board[y][x]!=0:
                ny,nx=y+dy,x+dx
                if 0>ny or ny>=8 or 0>nx or nx>=8:
                    continue
                while True:
                    if 0>ny or ny>=8 or 0>nx or nx>=8:
                        ny,nx=ny-dy,nx-dx
                        board[ny][nx],board[y][x]=board[y][x],0
                        break
                    elif board[ny][nx]!=0:
                        if board[y][x]==board[ny][nx]:
                            if not check[ny][nx]:
                                board[ny][nx]+=board[y][x]
                                board[y][x]=0
                                check[ny][nx]=True
                            else:
                                board[ny-dy][nx-dx],board[y][x]=board[y][x],0    
                        else:
                            if (ny-dy,nx-dx)!=(y,x):
                                board[ny-dy][nx-dx],board[y][x]=board[y][x],0
                        break      
                    ny+=dy
                    nx+=dx        
move_board(direction)
for lst in board:
    print(*lst)
