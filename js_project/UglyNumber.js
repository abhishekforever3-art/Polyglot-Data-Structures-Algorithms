let n = 12;
let temp = n;
if (n<0){
    console.log(temp + " is not a Ugly Number");
}

while (n%2===0){
    n= Math.floor (n/2);
 }
while (n%3===0){
    n= Math.floor (n/3);
}
while ( n%5===0){
    n= Math.floor (n/5);
}
if (n ===1){
    console.log ( temp + " is a ugly Number");
}
else {
    console.log ( temp + " is not a ugly number");
}
