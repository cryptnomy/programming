def solution(phone_book):
    answer = True
    hash_map = {}
    for phone_number in phone_book:
        hash_map[phone_number] = 1
    for phone_number in phone_book:
        tmp = ""
        for number in phone_number:
            tmp += number
            if tmp in hash_map and tmp != phone_number:
                answer = False
    return answer

if __name__ == '__main__':
    # phone_book                        return
    # ["119", "97674223", "1195524421"] false
    # ["123","456","789"]               true
    # ["12","123","1235","567","88"]	false
    phone_book = ["119", "97674223", "1195524421"]

    ans = solution(phone_book)

    print(ans)