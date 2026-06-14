let s1 = "abhishek.forever3@gmail.com";
let dotIndex = -1;
let length = s1.length;

for (let i = length-1; i >=0; i--){

    if (s1.charAt(i)=='.'){
        dotIndex = i;
        break;
    }
}
if (dotIndex== -1 || dotIndex == length -1){
    console.log ("Error: No valid file extension found.");
}
else{
    let extension = "";

    for (let i=dotIndex+1 ; i<length; i++) {
        extension+=s1.charAt(i);
    }
    console.log("Full Filename : " + s1);
    console.log("Dot Located At: Index " + dotIndex);
    console.log("Extension Only: " + extension);
}