package io.tony.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/23
 */
public class SubstringAllWords {

  public List<Integer> findSubstring(String s, String[] words) {
    if (s.isBlank()) {
      return Collections.emptyList();
    }
    if (words == null || words.length == 0) {
      return Collections.emptyList();
    }
    if (words[0].length() > s.length()) {
      return Collections.emptyList();
    }
    if (words.length == 1 && words[0].equals(s)) {
      return Arrays.asList(0);
    }
    Map<String, Integer> validWordAndRepeat = new HashMap<>();
    for (String word : words) {
      final Integer orDefault = validWordAndRepeat.getOrDefault(word, 0);
      validWordAndRepeat.put(word, orDefault + 1);
    }
    Map<String, Integer> wordSeen = new HashMap<>();
    int wordLen = words[0].length();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < s.length() - wordLen; i++) {
      final String startWord = s.substring(i, i + wordLen);
      if (!validWordAndRepeat.containsKey(startWord)) {
        wordSeen.clear();
        continue;
      }
      wordSeen.put(startWord, 1);
      for (int j = 1; j < words.length; j++) {
        int start = i + j * wordLen;
        int end = start + wordLen;
        if (end <= s.length()) {
          final String substring = s.substring(start, end);
          final Integer repeatTimes = validWordAndRepeat.get(substring);
          if (repeatTimes != null) {
            final Integer orDefault = wordSeen.getOrDefault(substring, 0);
            if (orDefault + 1 <= repeatTimes) {
              wordSeen.put(substring, orDefault + 1);
            } else {
              break;
            }
          } else {
            break;
          }
        }
      }
      if (wordSeen.size() == validWordAndRepeat.size()) {
        boolean match = true;
        for (Map.Entry<String, Integer> vw : validWordAndRepeat.entrySet()) {
          final String word = vw.getKey();
          match = match && wordSeen.getOrDefault(word, 0) == vw.getValue().intValue();
        }
        if (match) {
          result.add(i);
        }
      }
      wordSeen.clear();
      if (s.length() - (i + 1) < words.length * wordLen) {
        break;
      }
    }
    return result;
  }

  public static void main(String[] args) {
//    ""
//[]
    final SubstringAllWords ss = new SubstringAllWords();
//    ss.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
//    ss.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
//    System.out.println(ss.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
//
//

//    System.out.println(ss.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
//    System.out.println(ss.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"}));
//    System.out.println(ss.findSubstring("a", new String[]{"a"}));
//     "ababaab" ["ab","ba","ba"]
//    System.out.println(ss.findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
    ;
    System.out.println(ss.findSubstring("abababab", new String[]{"a", "b", "a"}));
  }
}
