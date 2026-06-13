/* let n= 12322;
let reversed = 0;
let original = n;
while (n>0){
    let lastDigit = n%10;
    reversed = (reversed*10)+lastDigit;
    n= Math.floor(n/10);

}
if (original===reversed){
    console.log(original+" is a palendrome")
}
else{
    console.log(original+" is not a palendrome")
} */

    
   /*  function isPalendrome(N){
        let reversed = 0;
        let original = N;
        while(N>0){
            let lastDigit = N%10;
            reversed = (reversed*10)+lastDigit;
            N= Math.floor(N/10);
        }
        return original ===reversed;
    }
    let N = 12321;
    if (isPalendrome(N)){
        console.log(N + " is a palendrome")
    }
    else{
        console.log(N + " is not a palendrome")
    } */

function isPalendrome(N){
    let reversed = 0;
    let original = N;
    while(original>0){
        let lastDigit = original%10;
        reversed = (reversed*10)+lastDigit;
        original= Math.floor(original/10);
    }
        
    
   
    if (reversed=== N){
        console.log(N + " is a palendrome")
    }
    else{
        console.log(N + " is not a palendrome")
    }
}
isPalendrome(12321)