
a = [1, 2, 3, 4, 5]
K = 2
N = len(a)


b = [0] * N


for i in range(N):
    
    new_index = (i - K) % N
    
  
    b[new_index] = a[i]


print(b)