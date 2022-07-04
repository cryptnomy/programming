'''import sys
input_len, print_len = map(int, sys.stdin.readline().split())
q = []

def dfs(q, start, input_len, print_len):
    if len(q) == print_len:
        print(' '.join(map(str, q)))
        return
    for i in range(start, input_len+1):
        if i not in q:
            q.append(i)
            dfs(q, i+1, input_len, print_len)
            q.pop()

dfs(q, 1, input_len, print_len)'''

import sys
input_len, print_len = map(int, sys.stdin.readline().split())
q = []
res = []

def dfs(q, start, input_len, print_len):
    if len(q) == print_len:
        res.append(' '.join(map(str, q)))
        return
    for i in range(start, input_len+1):
        if i not in q:
            q.append(i)
            dfs(q, i+1, input_len, print_len)
            q.pop()

dfs(q, 1, input_len, print_len)
print('\n'.join(res))