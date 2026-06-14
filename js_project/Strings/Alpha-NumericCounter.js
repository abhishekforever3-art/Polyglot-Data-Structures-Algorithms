let s1 = "Abhi 2026!";
let letterCount = 0;
let digitcount = 0;
let symboleCount = 0;

for (let i = 0; i < s1.length; i++) {
    let x = s1.charAt(i);
    
    // JS doesn't have Character.isLetter(), so we use Regular Expressions (Regex)
    if (/[a-zA-Z]/.test(x)) {
        letterCount++;
    } 
    else if (/[0-9]/.test(x)) {
        digitcount++;
    } 
    else if (/\s/.test(x)) {
        // Whitespace match - do nothing
    } 
    else {
        symboleCount++;
    }
}

console.log("Original Text: \"" + s1 + "\"");
console.log("-------------------------");
console.log("Letters count: " + letterCount);
console.log("Digits count : " + digitcount);
console.log("Symbols count: " + symboleCount);