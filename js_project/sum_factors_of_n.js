/* function sumFactors(n) {
  let sum = 0;
  for (let i = 1; i <= n; i++) {
    if (n % i === 0) {
      sum += i;
    }
  }
  console.log(sum);
}

sumFactors(24); */

let n= 24;
let sum =0;
for (let i= 1; i<=n; i++) {
  if (n%i ===0){
    sum+=i;
  }
  console.log(sum);
}