import sys
read = sys.stdin.readline

for i in range(1, int(read()) + 1):
    li = list(map(int, read().split()))
    #print('#' + str(i), sum([i for i in li if i % 2 == 1]))
    print(f'#{i} {sum([i for i in li if i % 2 == 1])}')

'''
case_num = int(input())
for x in range(case_num):
    sum = 0
    odd_input = list(map(int, input().split()))
    for y in odd_input:
        if y % 2 == 1:
            sum += y
    print(f'#{x+1} {sum}')
'''