n,m = map(int,input().split())
n_list = list(map(int,input().split()))
n_list.sort()
visit = [False * n]
s = []
def dfs(ind,cnt):
	if cnt == m:
		print(*s)
		return

	for i in range(0,n):
		s.append(n_list[i])
		dfs(ind+1,cnt+1)
		s.pop()
	
dfs(0,0)