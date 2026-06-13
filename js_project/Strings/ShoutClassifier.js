let s1 = " Abhi 2026!";
let s2 = "";

for (let i = 0; i < s1.length; i++) {
    let ch = s1.charAt(i);
    
    if (ch >= 'a' && ch <= 'z') {
        // Look up code, subtract 32, and build character out of it
        let upperCh = String.fromCharCode(ch.charCodeAt(0) - 32);
        s2 = s2 + upperCh;
    } else {
        s2 = s2 + ch;
    }
}

console.log("Original Input  : \"" + s1 + "\"");
console.log("Shout Conversion: \"" + s2 + "\"");