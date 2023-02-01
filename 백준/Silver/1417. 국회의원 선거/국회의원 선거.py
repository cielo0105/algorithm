import heapq
n = int(input())
vote = []
one = int(input())
for _ in range(n-1):
	heapq.heappush(vote,-int(input()))
ans = 0
while vote:

		first = -heapq.heappop(vote)
		if first < one:
			break
		first -= 1
		heapq.heappush(vote,-first)
		one += 1
		ans += 1
print(ans)
