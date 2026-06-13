import math

def count_factors(n):
    if n <= 0:
        return 0
    
    count = 0
    sqrt_n = int(math.sqrt(n))
    
    for i in range(1, sqrt_n + 1):
        if n % i == 0:
            
            if i * i == n:
                count += 1
            else:
                
                count += 2
                
    return count


number = 36
print(f"The number of factors for {number} is: {count_factors(number)}")
