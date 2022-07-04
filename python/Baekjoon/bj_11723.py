'''import sys

read = sys.stdin.readline
write = sys.stdout.write

class Set:
    def __init__(self):
        self.set = dict(zip(list(range(1, 21)), [0]*20))
    
    def add(self, x):
        self.set[x] = 1
        
    def remove(self, x):
        self.set[x] = 0
        
    def check(self, x):
        return self.set[x]
    
    def toggle(self, x):
        self.set[x] = 1 - self.set[x]
    
    def _all(self):
        for i in range(1, 21):
            self.set[i] = 1
    
    def empty(self):
        for i in range(1, 21):
            self.set[i] = 0
            
s = Set()
ans = []
for _ in range(int(read())):
    order = read().split()
    if order[0] == 'add':
        s.add(int(order[1]))
    elif order[0] == 'remove':
        s.remove(int(order[1]))
    elif order[0] == 'check':
        ans.append(str(s.check(int(order[1]))))
    elif order[0] == 'toggle':
        s.toggle(int(order[1]))
    elif order[0] == 'all':
        s._all()
    elif order[0] == 'empty':
        s.empty()

write('\n'.join([i for i in ans]))'''

import sys

full = set([str(i) for i in range(1, 21)])
s = set()
for _ in range(int(input())):
    line = sys.stdin.readline()
    order = line.split()[0]
    if order == 'empty':
        s = set()
        continue
    elif order == 'all':
        s = full
        continue
    x = line.split()[1]
    if order == 'add':
        s.add(x)
    elif order == 'remove':
        if x in s:
            s.remove(x)
    elif order == 'check':
        print('01'[x in s])
    elif order == 'toggle':
        if x in s:
            s.remove(x)
        else:
            s.add(x)