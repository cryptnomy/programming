'''from timeit import timeit

def sum1(li):
    from itertools import accumulate
    return list(accumulate(li))

def sum2(li):
    return [(sum(li[:i + 1])) for i in range(len(li))]

def sum3(li):
    import numpy as np
    return np.cumsum(li)

a = list(range(1, 6))*2

#print(timeit(lambda: sum1(a), number=1000))
#print(timeit(lambda: sum2(a), number=1000))
#print(timeit(lambda: sum3(a), number=1000))
print(sum1(a))
print(sum2(a))
print(sum3(a))'''

n, r, c = 10, 7, 7
print(int(f'{c:b}', 4) + 2 * int(f'{r:b}', 4))
print(f'{c:b}')
print(int(f'{c:b}', 4))
print(int('111', 4))
