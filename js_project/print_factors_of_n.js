/* function printFactors(n) {
  let factors = [];
  for (let i = 1; i <= n; i++) {
    if (n % i === 0) {
      factors.push(i);
    }
  }
  console.log(factors.join(", "));
}

printFactors(24); */

let n = 24; 
let factorsString = ""; 
for (let i = 1; i <= n; i++) {
  if (n % i === 0) {
  
    factorsString += i + ", "; 
  }
}

console.log(factorsString);

