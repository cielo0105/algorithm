from collections import Counter
def solution(topping):
    answer = 0
    r_t = Counter(topping)
    l_t = set()
    left = 0
    right = len(r_t)
    for i in range(len(topping)-1):
        if topping[i] not in l_t:
            l_t.add(topping[i])
            left+=1
        r_t[topping[i]] -= 1
        if r_t[topping[i]] == 0: 
            right-=1
        if left==right: answer+=1    
    return answer