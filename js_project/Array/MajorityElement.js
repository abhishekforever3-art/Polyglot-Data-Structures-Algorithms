let n=[ 1, 2, 2, 2, 2, 2, 2, 2, 2, 4, 5, 6 ];
let candidate = 0;
let count = 0;
let temp = count;
for (let i=0; i<a.length; i++){
    if (count==0){
        candidate=  a[i];
    }
    if (a[i]==candidate){
        count ++;
    }
    else{
        count--;
    }
}
console.log(count," -------");
console.log(candidate, "********");
for (let i=0; i<a.length; i++){
    if (a[i]==candidate){
        temp++
    }
}
if (temp>a.length/2){
    console.log("Majority Element: " , candidate)
}
else{
    console.log("-1")
}