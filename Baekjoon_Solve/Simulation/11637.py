# 인기 투표 (11637번)
T = int(input().rstrip())
for tc in range(T):
    n = int(input().rstrip())
    total = 0
    winner = 0
    max_score = 0
    cnt = 0  # 최다 득표자 수
    for i in range(1, n + 1):
        score = int(input().rstrip())
        total += score
        if max_score < score:
            winner = i
            cnt = 1
            max_score = score
        elif max_score == score:
            cnt += 1
    if cnt > 1:
        print("no winner")
    elif max_score <= total // 2:
        print(f"minority winner {winner}")
    else:
        print(f"majority winner {winner}")

