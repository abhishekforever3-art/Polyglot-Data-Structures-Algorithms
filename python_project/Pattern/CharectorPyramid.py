n = 4  

for i in range(1, n + 1):
    spaces = " " * (n - i)
    
    
    char = chr(65 + i - 1) 
    
    
    chars = char * (2 * i - 1)
    
    print(spaces + chars)