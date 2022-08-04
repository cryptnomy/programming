import sys
read = sys.stdin.readline

T = int(read())
ret = []
for _ in range(T):
    stack = []
    parentheses = read()
    for p in parentheses:
        if p == '(':
            stack.append(p)
        elif p == ')':
            if stack:
                stack.pop()
            else: # empty stack
                ret.append('NO')
                break
    else:
        if stack:
            ret.append('NO')
        else:
            ret.append('YES')
print('\n'.join(ret))