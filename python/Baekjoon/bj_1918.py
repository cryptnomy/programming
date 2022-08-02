expr = input()

stack = []
answer = ''

for char in expr:
    if char.isalpha():
        answer += char
    else:
        if char == '(':
            stack.append(char)
        elif char == '*' or char == '/':
            while stack and (stack[-1] == '*' or stack[-1] == '/'):
                answer += stack.pop()
            stack.append(char)
        elif char == '+' or char == '-':
            while stack and stack[-1] != '(':
                answer += stack.pop()
            stack.append(char)
        elif char == ')':
            while stack and stack[-1] != '(':
                answer += stack.pop()
            stack.pop()

while stack:
    answer += stack.pop()

print(answer)