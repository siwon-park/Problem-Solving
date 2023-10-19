# 2033년 밈 투표 (29731번)
import sys
input = sys.stdin.readline

dic = {'Never gonna give you up', 'Never gonna let you down',
       'Never gonna run around and desert you', 'Never gonna make you cry',
       'Never gonna say goodbye', 'Never gonna tell a lie and hurt you',
       'Never gonna stop'}

N = int(input().rstrip())  # 테스트 케이스의 수
ans = "No"
for _ in range(N):
    word = input().rstrip()
    if word not in dic:
        ans = "Yes"

print(ans)
