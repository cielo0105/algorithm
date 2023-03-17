from itertools import combinations
def solution(number):
    comb = combinations(number,3)
    ans = 0
    for c in comb:
        sum = 0
        for i in c:
            sum += i
        if sum == 0:  ans+=1
    return ans