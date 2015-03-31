import  java.util.HashMap;
/**
 * Created by wyzhangdongsheng1 on 15-3-31.
 */
public class _3_LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubString(String s){
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i)) + 1);
//                j = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
    public int lengthOfLongestSubString1(String s) {
        char[] ss = s.toCharArray();
        int[] loop1 = new int[ss.length + 1];
        int[] loop2 = new int[ss.length + 1];
        for (int i = 0; i < ss.length; i++) {
            int j = i + 1;
            while (j < ss.length && ss[i] != ss[j]){
                j++;
            }
            loop1[i] = j;
        }
        for(int i = 0; i < ss.length; i++){
            loop2[i] = loop1[i];
            for(int j = loop1[i] - 1; j > i; j--){
                if(loop2[i] > loop1[j]){
                    loop2[i] = loop1[j];
                }
            }
            loop2[i] = loop2[i] - i;
        }
        int max = loop2[0];
        for(int i = 1; i  < ss.length; i++){
            if(max < loop2[i]) max = loop2[i];
        }
        return max;
    }

    public static void main(String[] args) {
        _3_LongestSubStringWithoutRepeatingCharacters obj = new _3_LongestSubStringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubString("abba"));
    }
}
