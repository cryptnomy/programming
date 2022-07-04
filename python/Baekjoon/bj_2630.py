'''
Divide and conquer
1. input square가 1만으로 이루어져 있다면 ++cnt
2. input square side length > 1 체크
3. input square가 0 또는 1만으로 이루어져있지 않다면
4. 4등분 (input // 4)
-> 4등분을 코드로 표현해내는 방법?
'''
'''
import sys

n = int(sys.stdin.readline())
colored_paper = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
res = []

def divide_paper(x, y, n):
    color = colored_paper[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            if colored_paper[i][j] != color:
                divide_paper(x, y, n//2)
                divide_paper(x + n//2, y, n//2)
                divide_paper(x, y + n//2, n//2)
                divide_paper(x + n//2, y + n//2, n//2)
                return
    if color == 1:
        res.append(1)
    else:
        res.append(0)

divide_paper(0, 0, n)
print(res.count(0))
print(res.count(1))
'''
'''
생각해보아야 할 것: return 삽입한 것.
4등분한 구역 내에서 하나의 케이스만이라도 if 문에 걸리면 divide and conquer 알고리즘을 실행하고 빠져나옴.
* 중간에 함수를 종료시키기 위한 수단 *
break와 다름에 유의. break 문으로 구성했다면, for i in range(x, x + n) loop로 가게 되려나?
'''
import sys

class Solution:
    def __init__(self, paper, side_length):
        self.paper = paper
        self.length = side_length
        self.zeros = 0
        self.ones = 0
    
    def divide_paper(self, x, y, n):
        base_color, half_n = self.paper[x][y], n//2
        for i in range(x, x + n):
            for j in range(y, y + n):
                if paper[i][j] != base_color:
                    self.divide_paper(x, y, half_n)
                    self.divide_paper(x + half_n, y, half_n)
                    self.divide_paper(x, y + half_n, half_n)
                    self.divide_paper(x + half_n, y + half_n, half_n)
                    return
        if base_color == 0:
            self.zeros += 1
        else:
            self.ones += 1

side_length = int(sys.stdin.readline())
paper = [list(map(int, sys.stdin.readline().split())) for _ in range(side_length)]
sol = Solution(paper, side_length)
sol.divide_paper(0, 0, side_length)
print(sol.zeros)
print(sol.ones)