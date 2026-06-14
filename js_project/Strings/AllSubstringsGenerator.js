let s1 = "abc";
let length = s1.length;

console.log("Generating all possible substrings for \"" + s1 + "\":\n");

for (let start = 0; start < length; start++) {
    for (let end = start; end < length; end++) {
        let sub = "";
        
        for (let i = start; i <= end; i++) {
            sub = sub + s1.charAt(i);
        }
        console.log("Start: " + start + ", End: " + end + " -> \"" + sub + "\"");
    }
}