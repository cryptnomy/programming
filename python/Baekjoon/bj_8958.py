'''
import sys

n = int(sys.stdin.readline())
for _ in range(n):
    s = 0
    expr = sys.stdin.readline().strip().split('X')
    for o in expr:
        len_o = len(o)
        s += len_o * (len_o + 1)//2
    print(s)
'''

'''
import sys
read = sys.stdin.readline


for _ in range(int(read())):
    answer = 0
    for line in read().rstrip().split('X'):
        answer += sum(range(1, len(line)+1))
    print(answer)
'''

import sys
read = sys.stdin.readline

[print(sum(sum(range(1, len(i)+1)) for i in read().rstrip().split('X'))) for _ in range(int(read()))]
