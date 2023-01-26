n = int(input())
n_list = []
for _ in range(n):
	day,score = map(int,input().split())
	n_list.append((day,score))
n_list.sort()
hw = []
n = n_list[-1][0]
ans = 0
for i in range(n,0,-1):
	while n_list and n_list[-1][0] == i:
		hw.append(n_list.pop()[1])
	hw.sort()

	if hw:
		ans += hw.pop()
	
print(ans)