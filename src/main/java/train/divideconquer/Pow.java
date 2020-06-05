package train.divideconquer;

/** https://leetcode-cn.com/problems/powx-n/ */
public class Pow {
  public static void main(String[] args) {
    double d = new Pow().myPow(2.0, 4);
  }

  public double myPow(double x, long n) {
    long N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }

    return myPowRecursion(x, N);
  }

  private double myPowRecursion(double x, long n) {
    if (n == 0) {
      return 1.0;
    }
    double half = myPowRecursion(x, n / 2);
    if (n % 2 == 0) {
      return half * half;
    } else {
      return half * half * x;
    }
  }

  private double myPowRecursion1(double x, long n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    if (n == -1) {
      return 1 / x;
    }
    double half = myPowRecursion1(x, n / 2);
    double rest = myPowRecursion1(x, n % 2);
    return rest * half * half;
  }
}
