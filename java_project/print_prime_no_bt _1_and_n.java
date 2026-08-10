class print_prime_no_bt_1_and_n {
  public static void printPrimes(int n) {
    for (int i = 2; i <= n; i++) {
      boolean isPrime = true;
      for (int j = 2; j <= Math.sqrt(i); j++) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        System.out.println(i);
      }
    }
  }

  public static void main(String[] args) {
    printPrimes(50);
  }
}