let s1 = "Abhi g";
let marker = "g";
if (s1.includes(marker)) {
    let end = s1.indexOf(marker);
    console.log("Extracted: " + s1.substring(0, end));
} else {
    console.log("Error: Marker not found.");
}