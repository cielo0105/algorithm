def solution(elements):
    answer = 0
    ans = set()
    e = elements+elements
    print(e)
    for i in range(len(elements)):
        for j in range(len(elements)):
            ans.add(sum(e[i:i+j]))
           
    answer = len(ans)
    return answer