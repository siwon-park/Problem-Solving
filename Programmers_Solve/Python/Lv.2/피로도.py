# 피로도(프로그래머스 위클리 챌린지 12주차)
from copy import deepcopy
def solution(k, dungeons):
    n=len(dungeons)
    result=[]
    def dfs(left,dungeons,counts):
        for needs,uses in dungeons: #던전의 필요 피로도, 소모 피로도에 대해
            if left>=needs: #남은 피로도가 필요 피로도보다 높을 경우
                left_dungeons=deepcopy(dungeons) #기존 던전 리스트를 deepcopy
                left_dungeons.remove([needs,uses]) #입장한 던전 내용을 남은 던전 리스트에서 제거
                dfs(left-uses,left_dungeons,counts+1) #남은 피로도와, 남은 던전 리스트, 던전 입장 횟수+1을 DFS탐색
        result.append(counts) #최댓값을 찾아야하기 때문에 답은 정상적으로 출력되지만, 그래도 dfs의 종료조건을 명시해주는게 좋을 듯 하다
    dfs(k,dungeons,0)
    return max(result)
#print(solution(80,[[80,20],[50,40],[30,10]]))
