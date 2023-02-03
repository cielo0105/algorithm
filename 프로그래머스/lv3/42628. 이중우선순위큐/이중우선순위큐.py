from heapq import heappush,heappop
def solution(operations):
    max_h = []
    min_h = []
    for i in operations:
        comm, num = i.split()
        if comm == 'I':
            heappush(max_h,-int(num))
            heappush(min_h,int(num))
        elif comm == 'D' and min_h: 
            if int(num) == 1:  #최댓값 삭제
                n = -heappop(max_h)
                min_h.remove(n)
            elif int(num) == -1:
                n = -heappop(min_h)
                max_h.remove(n)
    if min_h:
        return [-heappop(max_h),heappop(min_h)]
    else:
        return [0,0]
                
            