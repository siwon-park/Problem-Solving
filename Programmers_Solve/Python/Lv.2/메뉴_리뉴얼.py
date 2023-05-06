def solution(orders, course):
    answer = []
    # 각 코스별로 가장 많이 나왔어야 하고, 누군가의 부분집합이어야 함
    course_dict = dict() # 부분집합을 담을 딕셔너리
    
    # orders의 order가 알파벳별로 정렬이 되어있지 않으므로 정렬하여 리스트에 담음
    new_orders = []
    for order in orders:
        lst = list(order)
        lst.sort()
        new_orders.append("".join(lst))
    
    for order in new_orders: # 각 메뉴별로 부분집합을 계산
        subset(order, 0, "", course_dict)
    
    course_lst = [[] for _ in range(len(course))] # 각 단품메뉴 개수별로 코스메뉴를 담을 리스트
    for i in range(len(course)): # 단품메뉴 개수별로 코스메뉴를 리스트에 담음
        course_num = course[i]
        for course_menu in course_dict:
            if len(course_menu) == course_num and course_dict[course_menu] >= 2:
                course_lst[i].append((course_menu, course_dict[course_menu]))
        
        if course_lst[i]: # i번째 코스메뉴 리스트에 요소가 있으면 정렬함
            course_lst[i].sort(key=lambda x: (-x[1], x[0])) # 나온 횟수 내림차순, 메뉴 오름차순으로 정렬
            best_count = course_lst[i][0][1] # course_num개로 이루어진 코스메뉴 중 가장 많이 나온 횟수
            for menu, cnt in course_lst[i]: # 최고 등장 횟수와 같은 메뉴 구성만 담고 아니면 break 함
                if best_count == cnt:
                    answer.append(menu)
                else:
                    break
                    
    answer.sort() # 정렬
    return answer


def subset(words, k, ss, dic):
    if k == len(words):
        if len(ss) >= 2:
            dic[ss] = dic.get(ss, 0) + 1
        return
    # 현재의 문자열을 선택하지 않음
    subset(words, k + 1, ss, dic)
    # 현재의 문자열을 선택함
    subset(words, k + 1, ss + words[k], dic)