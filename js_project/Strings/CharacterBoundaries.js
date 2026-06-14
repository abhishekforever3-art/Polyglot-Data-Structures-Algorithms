let s1 = "java";
console.log(s1);

console.log("Get length of s1: " + s1.length);
console.log("first charector of the s1: " + s1.charAt(0));
// JS also allows array-like indexing: s1[0]

console.log("last charector of the s1: " + s1.charAt(s1.length - 1));

// Checking for null or empty string
if (!s1) {
    console.log("Graceful Message: The provided string is empty!");
}