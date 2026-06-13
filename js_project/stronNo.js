/* let n = 146;
let sum = 0;
let temp = n;
while (temp>0){
    let lastDigit = temp%10;
    let Fact = 1;
    for (let i=1; i<=lastDigit; i++){
        Fact = Fact*i;
    }
    sum = sum+ Fact;
    temp= Math.floor(temp/10);
}
if(sum===n){
    console.log(n+ " is a Strong Number")
}
else{
    console.log(n+ " is not a Strong Number")
} */
/* 
function getFactorial(N){
    let Fact = 1;
    for (i=1; i<=N; i++){
        Fact = Fact * i;
    }
    return Fact; 
} */
function isStrongNumber(N){
    let sum= 0;
    let temp = N;
    while (temp>0){
        let lastDigit = temp%10;
        let Fact=1;
        for (let i=1; i<=lastDigit; i++){
            Fact= Fact*i;
        
        }
        sum = sum+ Fact;
        temp= Math.floor(temp/10);
    }
   return sum==N;

}
let N = 146;

if(isStrongNumber(N)){
    console.log (isStrongNumber(N)+ " is a Strong number")
}
else {
    console.log (isStrongNumber(N)+ " is not a Strong Number")
}