def solution(skill, skill_trees):
    answer = 0
    
    order = dict()
    for i in range(len(skill)):
        order[skill[i]] = i
        
    answer += len(skill_trees) # 처음엔 모두 가능한 스킬 트리로 가정함
    # 등장한 순서가 다르면 올바르지 않은 스킬 트리임
    for s_tree in skill_trees:
        m = len(s_tree)
        j = 0 # 순서
        for i in range(m):
            if s_tree[i] in order:
                if order[s_tree[i]] != j:
                    answer -= 1
                    break
                else:
                    j += 1
        
    return answer