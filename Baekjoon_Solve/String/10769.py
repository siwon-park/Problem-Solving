# 행복한지 슬픈지 (10769번)
import sys
input = sys.stdin.readline

line = input().rstrip()
n = len(line)
happy_cnt = 0
sad_cnt = 0
for i in range(n - 2):
    emotion = line[i:i+3]
    if emotion == ':-)':
        happy_cnt += 1
    elif emotion == ':-(':
        sad_cnt += 1

if happy_cnt == 0 and sad_cnt == 0:
    print("none")
elif happy_cnt == sad_cnt:
    print("unsure")
elif happy_cnt > sad_cnt:
    print("happy")
elif sad_cnt > happy_cnt:
    print("sad")

