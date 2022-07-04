'''import sys
read = sys.stdin.readline

input_len, print_len = map(int, read().split())
input_li = sorted(map(int, read().split()))
q = []
res = []

def dfs(q, input_li, input_len, print_len):
    if len(q) == print_len:
        res.append(' '.join(map(str, q)))
        return
    for i in input_li:
        if i not in q:
            q.append(i)
            dfs(q, input_li, input_len, print_len)
            q.pop()

dfs(q, input_li, input_len, print_len)
print('\n'.join(res))'''

import sys
from itertools import permutations
read = sys.stdin.readline

input_len, print_len = map(int, read().split())
input_lst = sorted(map(int, read().split()))

print('\n'.join(map(' '.join, permutations(map(str, input_lst), print_len))))