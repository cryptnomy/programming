def solution(prices):
    stack = []
    len_prices = len(prices)
    answer = [0] * len_prices
    for i in range(len_prices):
        if stack != []:
            while stack != [] and stack[-1][1] > prices[i]:
                past, _ = stack.pop()
                answer[past] = i - past
        stack.append([i, prices[i]])
    for i, s in stack:
        answer[i] = len(prices) - 1 - i
    return answer

if __name__ == '__main__':
    # prices            return
    # [1, 2, 3, 2, 3]   [4, 3, 1, 1, 0]
    prices = [1, 2, 3, 2, 3]
    
    ans = solution(prices)

    print(ans)

'''
def solution(prices):
    answer = []
    len_prices = len(prices)
    for i in range(len_prices-1):
        count = 1
        for j in range(i+1, len_prices):
            if prices[i] > prices[j]:
                answer.append(count)
                break
            else:
                count += 1
            if j == len_prices - 1:
                count -= 1
                answer.append(count)
    answer.append(0)
    return answer
'''