import sys
line = sys.stdin.readline().rstrip()
joi, ioi = 0, 0
for i in range(len(line)-2):
    if line[i:i+3] == 'IOI':
        ioi += 1
    if line[i:i+3] == 'JOI':
        joi += 1
print(joi)
print(ioi)
