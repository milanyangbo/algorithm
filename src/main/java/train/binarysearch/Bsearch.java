package train.binarysearch;

public class Bsearch {

  public int bsearch(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (a[mid] > value) {
        high = mid - 1;
      } else if (a[mid] < value) {
        low = mid + 1;
      } else {
        if ((mid == 0) || (a[mid - 1] != value)) return mid;
        else high = mid - 1;
        //        if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
        //        else low = mid + 1;
      }
    }
    return -1;
  }
}
