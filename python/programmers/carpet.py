from multiprocessing.spawn import _main
from unittest import main


def solution(brown, yellow):
    # Solve x^2 - px + q = 0
    # where p = row + col = (brown + 4) // 2 and
    # q = row * col = brown + yellow
    p = (brown + 4) // 2
    q = brown + yellow
    for x in range(3, p):
        if x * x - p * x + q == 0:
            return [q // x, x]

if __name__ == '__main__':
    brown = 24
    yellow = 24
    print(solution(brown, yellow))