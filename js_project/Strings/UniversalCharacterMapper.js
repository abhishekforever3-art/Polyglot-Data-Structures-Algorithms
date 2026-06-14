let s1 = "abhishek🚀";
let rawCodeUnits = s1.length; 

// Modern JS allows us to easily get actual visual symbol counts by converting the string to an Array
let visualSymbols = Array.from(s1).length;

console.log("Original Text   : " + s1);
console.log("---------------------------------------");
console.log("Internal Code Units (text.length) : " + rawCodeUnits);
console.log("Visual Symbols (Array.from)       : " + visualSymbols);
console.log("---------------------------------------");

console.log("CRITICAL LESSON: Printing using a standard char loop:");
let output = "";
for (let i = 0; i < s1.length; i++) {
    output = output + "[" + s1.charAt(i) + "] ";
}
console.log("Output: " + output);