package Sort;

public class Sort {

  public void bubbleSort(int[] a) {
    if (a == null && a.length == 0) {
      return;
    }
    for (int i = 0; i < a.length; ++i) {
      // 提前退出冒泡循环的标志位
      boolean flag = false;
      for (int j = 0; j < a.length - i - 1; ++j) {
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
          flag = true; // 表示有数据交换
        }
      }
      if (!flag) {
        break; // 没有数据交换，提前退出
      }
    }
  }

  public static void main(String[] args) {
    int[] a = new int[] {4, 5, 6, 1, 3, 2};
    new Sort().insertionSort(a);
  }

  // 插入排序，a表示数组，n表示数组大小
  public void insertionSort(int[] a) {
    if (a == null && a.length == 0) {
      return;
    }

    for (int i = 1; i < a.length; ++i) {
      int value = a[i];
      int j = i - 1;
      // 查找插入的位置
      for (; j >= 0; --j) {
        if (a[j] > value) {
          a[j + 1] = a[j]; // 数据移动
        } else {
          break;
        }
      }
      a[j + 1] = value; // 插入数据
    }
  }
}
