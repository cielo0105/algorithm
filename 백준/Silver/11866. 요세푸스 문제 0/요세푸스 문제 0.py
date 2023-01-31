from collections import deque
n,k = map(int,input().split())
dq = deque([i for i in range(1,n+1)])
ans = []
cnt = 0
while dq:
	a = dq.popleft()
	cnt += 1
	if cnt == k:
		ans.append(a)
		cnt = 0
	else:
		dq.append(a)
	
print("<",end="")
for i in range(n-1):
	print(ans[i],end=', ')
print(ans[-1],end='')
print(">")