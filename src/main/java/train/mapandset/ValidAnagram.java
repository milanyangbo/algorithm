package train.mapandset;

/** https://leetcode-cn.com/problems/valid-anagram/ */
public class ValidAnagram {

  public static void main(String[] args) {
    new ValidAnagram().isAnagram("anagram", "nagaram");
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    //    char[] chars1 = s.toCharArray();
    //    char[] chars2 = t.toCharArray();
    //    Arrays.sort(chars1);
    //    Arrays.sort(chars2);
    //
    //    return Arrays.equals(chars1, chars2);

    char[] chars1 = s.toCharArray();
    char[] chars2 = t.toCharArray();

    int[] counter = new int[26];

    for (int i = 0; i < chars1.length; i++) {
      counter[chars1[i] - 'a']++;
      counter[chars2[i] - 'a']--;
    }

    for (int i = 0; i < counter.length; i++) {
      int count = counter[i];
      if (count != 0) {
        return false;
      }
    }

    return true;
  }
}
