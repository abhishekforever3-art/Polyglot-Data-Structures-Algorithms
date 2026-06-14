s1 = " Abhi 2026!"
s2 = ""

for i in range(0, len(s1)):
    ch = s1[i]
    
    if ch >= 'a' and ch <= 'z':
        # ord(ch) gets the ASCII number, chr() converts it back to text
        upperCh = chr(ord(ch) - 32)
        s2 = s2 + upperCh
    else:
        s2 = s2 + ch

print("Original Input  : \"" + s1 + "\"")
print("Shout Conversion: \"" + s2 + "\"")