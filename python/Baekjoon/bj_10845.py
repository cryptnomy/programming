import sys
from collections import deque

read = sys.stdin.readline
write = sys.stdout.write

class Queue:
    deq = deque()

    def push(self, x):
        self.deq.append(x)
    
    def pop(self):
        return -1 if self.empty() == 1 else self.deq.popleft()
    
    def size(self):
        return len(self.deq)
    
    def empty(self):
        return 1 if len(self.deq) == 0 else 0
    
    def front(self):
        return -1 if self.empty() == 1 else self.deq[0]
    
    def back(self):
        return -1 if self.empty() == 1 else self.deq[-1]
    
n = int(read())
que = Queue()

for _ in range(n):
    order = read().split()
    if order[0] == 'push':
        que.push(int(order[1]))
    elif order[0] == 'pop':
        write(str(que.pop()) + '\n')
    elif order[0] == 'size':
        write(str(que.size()) + '\n')
    elif order[0] == 'empty':
        write(str(que.empty()) + '\n')
    elif order[0] == 'front':
        write(str(que.front()) + '\n')
    elif order[0] == 'back':
        write(str(que.back()) + '\n')
