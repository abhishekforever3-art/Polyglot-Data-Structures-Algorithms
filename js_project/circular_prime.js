function isPrime(num) {
  if (num < 2) return false;
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) return false;
  }
  return true;
}

function checkCircularPrime(n) {
  let s = n.toString();
  for (let i = 0; i < s.length; i++) {
    if (!isPrime(Number(s))) return false;
    s = s.slice(1) + s[0]; 
  }
  return true;
}

console.log(checkCircularPrime(197));