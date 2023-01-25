import sys
from collections import defaultdict

dic = defaultdict(int)

n = int(input())
n_list = list(map(int,sys.stdin.readline().split()))
for i in n_list:
	dic[i] += 1

m = int(input())
m_list = list(map(int,sys.stdin.readline().split()))
ans = []
for i in m_list:
	ans.append(dic[i])

print(*ans)