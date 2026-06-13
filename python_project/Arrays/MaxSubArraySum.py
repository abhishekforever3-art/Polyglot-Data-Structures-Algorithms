a = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
current_max = a[0]
global_max = a[0]
for i in range(1, len(a)):
    
    current_max = max(a[i], current_max + a[i])

   
    if current_max > global_max:
        global_max = current_max
        
print(global_max)