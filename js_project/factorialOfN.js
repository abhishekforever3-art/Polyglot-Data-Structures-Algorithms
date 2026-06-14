  /*   let n = 10;
    let Fact= 1;
    for (let i=1; i<=n; i++){
        Fact = Fact*i;

    }
    console.log(Fact);
 */
 
x=10;
function getFactorial(N){
    let Fact = 1;
    for (let i=1; i<=N; i++){
        Fact = Fact*i;
    }
    return Fact;
}
console.log(getFactorial(x));

