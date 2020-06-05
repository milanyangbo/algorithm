package train.queuestackarray;

import java.util.*;

/** https://leetcode-cn.com/problems/group-anagrams/ */
public class GroupAnagrams {

  public static void main(String[] args) {
    new GroupAnagrams().groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] ca = str.toCharArray();
      Arrays.sort(ca);
      String key = String.valueOf(ca);

      if (map.containsKey(key)) map.get(key).add(str);
      else {
        map.put(
            key,
            new ArrayList<String>() {
              {
                add(str);
              }
            });
      }
    }

    result.addAll(map.values());
    return result;
  }
}
