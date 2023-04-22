n,k = map(int,input().split())
n_list = list(map(int,input().split()))
s = sum(n_list)
ans = 0

if (k//s)%2 == 1:
    left = k%s
    for i in range(n-1,-1,-1):
        left-=n_list[i]
        if left < 0:
            ans = i+1
            break
else:

    left = k%s
    for i in range(n):
        left-=n_list[i]
        if left < 0:
            ans = i+1
            break
print(ans)