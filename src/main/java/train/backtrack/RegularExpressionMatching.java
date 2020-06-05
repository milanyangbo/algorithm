package train.backtrack;

/** https://leetcode-cn.com/problems/regular-expression-matching/ */
public class RegularExpressionMatching {

  /**
   * 这种匹配思路其实就是不断地减掉s和p的可以匹配首部，直至一个或两个字符串被减为空的时候，根据最终情况来得出结论。
   *
   * <p>如果只是两个普通字符串进行匹配，按序遍历比较即可：
   *
   * <p>if( s.charAt(i) == p.charAt(i) ) 如果正则表达式字符串p只有一种"."一种特殊标记，依然是按序遍历比较即可 ：
   *
   * <p>if( s.charAt(i) == p.charAt(i) || p.charAt(i) == '.' ) 上述两种情况实现时还需要判断字符串长度和字符串判空的操作。
   *
   * <p>但是，"*"这个特殊字符需要特殊处理，当p的第i个元素的下一个元素是星号时会有两种情况：
   *
   * <p>i元素需要出现0次，我们就保持s不变，将p的减掉两个元素，调用isMatch。例如s：bc、p：a*bc，我们就保持s不变，减掉p的"a*"，调用isMatch(s:bc,p:bc)。
   * i元素需要出现一次或更多次，先比较i元素和s首元素，相等则保持p不变，s减掉首元素，调用isMatch。例如s：aabb、p：a*bb，就保持p不变，减掉s的首元素，调用isMatch(s:abb,p:a*bb)。
   * 此时存在一些需要思考的情况，例如s：abb、p：a*abb，会用两种方式处理：
   *
   * <p>按照上述第二种情况比较i元素和s首元素，发现相等就会减掉s的首字符，调用isMatch(s:bb,p:a*abb)。在按照上述第一种情况减去p的两个元素，调用isMatch(s:bb,p:abb)，最终导致false。
   * 直接按照上述第一种情况减去p的两个元素，调用isMatch(s:abb,p:abb)，最终导致true。 所以说这算是一种暴力方法，会将所有的情况走一边，看看是否存在可以匹配的情况
   */
  public boolean isMatch(String s, String p) {
    if (p.isEmpty()) return s.isEmpty();
    boolean first_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
    if (p.length() > 1 && p.charAt(1) == '*') {
      return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
    } else {
      return first_match && isMatch(s.substring(1), p.substring(1));
    }
  }
}
