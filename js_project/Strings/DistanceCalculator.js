let s1 = "abc";
let s2 = "xyz";
let totalDistance = 0;

for (let i = 0; i < s1.length; i++) {
    // JS uses .charCodeAt(index) to get the ASCII numerical value
    let val1 = s1.charCodeAt(i);
    let val2 = s2.charCodeAt(i);
    
    let ascii1 = val1;
    let ascii2 = val2;

    console.log("The ascii value of " + val1 + " " + ascii1);
    console.log("The ascii value of " + val2 + " " + ascii2);

    // Math.abs() works exactly like Java!
    let currentdistance = Math.abs(val1 - val2);
    console.log(currentdistance + "========");
    
    totalDistance = totalDistance + currentdistance;
}

console.log("String 1: " + s1);
console.log("String 2: " + s2);
console.log("---------------------------------");
console.log("Cumulative ASCII Distance: " + totalDistance);