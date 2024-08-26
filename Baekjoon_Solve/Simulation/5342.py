# Billing (5342번)
import sys
input = sys.stdin.readline

ans = 0
_dict = {'Paper': 57.99, 'Printer':	120.50, 'Planners': 31.25, 'Binders': 22.50, 'Calendar': 10.95, 'Notebooks': 11.20,
         'Ink': 66.95}

while True:
    inp = input().rstrip()
    if inp == 'EOI':
        break
    ans += _dict.get(inp)

print(f'${ans:.2f}')

