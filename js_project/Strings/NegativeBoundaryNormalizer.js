let s1 = "Abhishek";
let start = -3;
let end = -1;
let length = s1.length;

if (start < 0) {
    start = length + start;
}

if (end < 0) {
    end = length + end;
}

if (start < 0 || end > length || start > end) {
    console.log("Error: Normalized indices out of practical string bounds.");
} else {
    let Sliced = "";
    for (let i = start; i < end; i++) {
        Sliced = Sliced + s1.charAt(i);
    }
    console.log("------------------------------------");
    console.log("Normalized Positive Start: " + start);
    console.log("Normalized Positive End  : " + end);
    console.log("Extracted Result         : \"" + Sliced + "\"");
}