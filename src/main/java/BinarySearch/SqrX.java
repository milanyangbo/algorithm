package BinarySearch;

/** https://leetcode-cn.com/problems/sqrtx/ */
public class SqrX {

  public static void main(String[] args) {
    new SqrX().mySqrt(8);
  }

  /** 1.二分法 y=x平方 单调递增 1e-9 */
  public int mySqrt(int x) {
    if (x < 2) {
      return x;
    }

    int lower = 2;
    int upper = x / 2;
    while (lower <= upper) {
      int mid = (upper - lower) / 2 + lower;
      if (mid == x / mid) {
        return mid;
      } else if (mid > x / mid) {
        upper = mid - 1;
      } else {
        lower = mid + 1;
      }
    }
    return upper;
  }
}
