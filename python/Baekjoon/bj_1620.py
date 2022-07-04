'''import sys
input = sys.stdin.readline

n, m = map(int, input().split())
d = {}

for i in range(1, n + 1):
    a = input().rstrip()
    d[i] = a
    d[a] = i

for i in range(m):
    quest = input().rstrip()
    if quest.isdigit():
        print(d[int(quest)])
    else:
        print(d[quest])'''

import sys
input_ = sys.stdin.readline

n, m = map(int, input_().split())
pkmn = []
pkmn_dic = {}
res = []
for i in range(1, n + 1):
    pk = input_().rstrip()
    pkmn.append(pk)
    pkmn_dic[pk] = i
for _ in range(m):
    query = input_().rstrip()
    if query.isdigit():
        res.append(pkmn[int(query) - 1])
    else:
        res.append(str(pkmn_dic[query]))
print('\n'.join(res))