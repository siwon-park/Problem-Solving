# 양궁대회(2022 KAKAO BLIND RECRUITMENT)
##############################################################################################
    # 문제: https://school.programmers.co.kr/learn/courses/30/lessons/92342
    # 구현, 백트랙킹
    # 작년에 못 푼 문제였는데, 올해 실력이 상승했나 싶어서 아껴뒀다가 다시 풀었는데, 테케 8, 18번을 통과 못해서
    # 엄청난 시간을 디버깅에 할애했다. 덕분에 몇개 좀 배울 수 있었다.
    # 매개변수를 함수 내부에서 변화시키지말 것 => 특히 백트랙킹에서 오류가 생김(꼭 필요한 변수만 변화시킬 것!)
    # 문제 조건에 맞는다고 생각해서 무조건 정렬하지 말 것 => 너는 맞다고 생각하는데, 정렬 결과가
    # 실제 문제 조건과 맞지 않는 경우가 있음 => 가장 낮은 점수를 가장 많이 맞춘 경우, 같다면 그 다음 낮은 점수 순
    # 이렇게 할 때, 그냥 단순히 정렬해버리면 문제 조건과 부합하지 않음.
##############################################################################################
max_score = -int(1e9)
answer = [-1]
def solution(n, info):
    global max_score
    lst = [0] * 11
    def dfs(left, s, lst):
        global max_score, answer

        if left < 0:
            return
        if left == 0 or s == 11:
            lion_score, apeach_score = 0, 0
            tmp_lst = lst[:]
            tmp_lst[-1] += left
            for j in range(11):
                if tmp_lst[j] and tmp_lst[j] > info[j]:
                    lion_score += (10 - j)
                elif info[j]:
                    apeach_score += (10 - j)
            if lion_score > apeach_score:
                if answer == [-1]:
                    answer = tmp_lst[:]
                if lion_score - apeach_score > max_score:
                    max_score = lion_score - apeach_score
                    answer = tmp_lst[:]
                elif lion_score - apeach_score == max_score:
                    flag = True
                    for i in range(10, -1, -1):
                        if tmp_lst[i] < answer[i]:
                            flag = False
                            break
                        elif tmp_lst[i] > answer[i]:
                            flag = True
                            break
                    if flag:
                        answer = tmp_lst[:]
            return

        for i in range(s, 11):
            # 맞추는 경우
            lst[i] += (info[i] + 1)
            dfs(left - (info[i] + 1), i + 1, lst)
            lst[i] -= (info[i] + 1)
            # 넘어가는 경우
            dfs(left, i + 1, lst)

    dfs(n, 0, lst[:])
    return answer
