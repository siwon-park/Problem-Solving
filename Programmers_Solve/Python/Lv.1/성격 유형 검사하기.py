# 성격 유형 검사하기(카카오 2022 인턴십)
# 딕셔너리를 활용해서, 점수를 산정한 뒤에 if-else구문을 활용해서 풀었다. 
def solution(survey, choices):
    answer = ''
    MBTI = {"R": 0, "T": 0, "C": 0, "F": 0, "J": 0, "M": 0, "A": 0, "N": 0}
    N = len(survey)
    for i in range(N):
        if choices[i] >= 5:
            MBTI[survey[i][1]] += choices[i] - 4
        elif choices[i] <= 3:
            MBTI[survey[i][0]] += 4 - choices[i]

    if MBTI["R"] >= MBTI["T"]:
        answer += "R"
    else:
        answer += "T"
    if MBTI["C"] >= MBTI["F"]:
        answer += "C"
    else:
        answer += "F"
    if MBTI["J"] >= MBTI["M"]:
        answer += "J"
    else:
        answer += "M"
    if MBTI["A"] >= MBTI["N"]:
        answer += "A"
    else:
        answer += "N"
    return answer
