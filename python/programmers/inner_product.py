def solution(a, b):
    from functools import reduce
    return sum([reduce(lambda x, y: x * y, j) for j in [i for i in zip(a, b)]])
    # return sum(list(map(lambda x, y: x * y, a, b)))
    # return sum([x * y for x, y in zip(a, b)])
    # solution = lambda a, b: sum(x * y for x, y in zip(a, b))

if __name__ == '__main__' :
    a = [-1, 0, 1]
    b = [1, 0, -1]
    ans = solution(a, b)
    print(ans)
