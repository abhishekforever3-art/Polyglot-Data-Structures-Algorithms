import re
text = "myVariableName"
n =""
def add_underscore_lowercase(m):
    uc = m.group(1)
    return "_"+uc.lower()

    

print (re.sub(r"([A-Z])",add_underscore_lowercase,text))


print (re.sub(r"([A-Z])", lambda m:f"_{m.group(1).lower()}",text))