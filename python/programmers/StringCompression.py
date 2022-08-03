def solution(s):
    len_s = len(s)
    answer = []
    if len_s < 2:
        return len_s
    # Check duplicated strings of length i
    for i in range(1, len_s//2 + 1):
        temp = s[:i]    # basis string
        count = 1
        compressed = ''
        for j in range(i, len_s, i):
            # The next string is the same as the basis
            if temp == s[j:j+i]:
                count += 1
            else:
                # No duplicate
                if count == 1:
                    compressed += temp
                # More than two duplicates
                else:
                    compressed += str(count)+temp
                temp = s[j:j+i]
                count = 1
        if count == 1:
            compressed += temp
        else:
            compressed += str(count)+temp
        answer.append(len(compressed))
    return min(answer)

if __name__ == '__main__':
    s = "aabbaccc"
    answer = solution(s)
    print(answer)

'''
def compress(text, token_len):
    words = [text[i:i+token_len] for i in range(0, len(text), token_len)]
    res = []
    word_curr = words[0]
    cnt_curr = 1
    for a, b in zip(words, words[1:]+['']):
        if a == b:
            cnt_curr += 1
        else:
            res.append([word_curr, cnt_curr])
            word_curr = b
            cnt_curr = 1
    print(list(len(word) + (len(str(cnt)) if cnt > 1 else 0) for word, cnt in res))
    return sum(len(word) + (len(str(cnt)) if cnt > 1 else 0) for word, cnt in res)

def solution(text):
    return min(compress(text, token_len) for token_len in list(range(1, len(text)//2 + 1)) + [len(text)])
'''