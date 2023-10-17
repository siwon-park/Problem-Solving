# 진흥원 세미나 (30087번)
import sys
input = sys.stdin.readline

lecture_dict = {'Algorithm': 204, 'DataAnalysis': 207, 'ArtificialIntelligence': 302, 'CyberSecurity': 'B101',
                'Network': 303, 'Startup': 501, 'TestStrategy': 105}

N = int(input().rstrip())  # 테스트 케이스의 수
for _ in range(N):
    lecture = input().rstrip()
    print(lecture_dict[lecture])
