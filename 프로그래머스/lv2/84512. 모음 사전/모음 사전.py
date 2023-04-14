from itertools import product
def solution(word):
    alpha = ['A','E','I','O','U']
    result = []
    for i in range(1,6):
        for p in product(alpha,repeat=i):
            result.append(''.join(p))
    result.sort()
    # print(result)
    answer = result.index(word)
    return answer+1