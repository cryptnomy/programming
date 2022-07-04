import sys
from collections import deque

read = sys.stdin.readline
write = sys.stdout.write

class Stack:
    deq = deque()
    
    def push(self, x):
        self.deq.append(x)
    
    def pop(self):
        return -1 if self.empty() == 1 else self.deq.pop()
    
    def size(self):
        return len(self.deq)
    
    def empty(self):
        return 1 if len(self.deq) == 0 else 0
    
    def top(self):
        return -1 if self.empty() == 1 else self.deq[-1]

n = int(read())
stack = Stack()

for _ in range(n):
    order = read().split()
    if order[0] == 'push':
        stack.push(int(order[1]))
    elif order[0] == 'pop':
        write(str(stack.pop()) + '\n')
    elif order[0] == 'size':
        write(str(stack.size()) + '\n')
    elif order[0] == 'empty':
        write(str(stack.empty()) + '\n')
    elif order[0] == 'top':
        write(str(stack.top()) + '\n')
