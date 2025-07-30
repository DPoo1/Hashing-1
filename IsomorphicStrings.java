// I use two arrays to ensure one-to-one character mapping between strings s and t.
// The sMap array tracks which character from t is mapped to each character in s.
// The tMap boolean array keeps track of whether a character in t has already been mapped. For each character in s, if a mapping already exists in sMap, I check if it matches the current character in t. If it doesn't, I return false. If no mapping exists, I ensure the target character from t hasn’t already been mapped using tMap; if it has, return false. Otherwise, I create the mapping and mark the character in t as used.

//Time complexity here is o(n) where n is the length of the string. The reason being we are only iterating once throughout the array and there is no other process to consume the time.

 //Space complexity here runs in constant space  even though we are using two external arrays the size of the arrays are constant and it's only 95 since there are only 95 ascii values. So other than that there are no other variables or temporary data structure that can consume additional space.

class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sMap = new char[95];
        boolean[] tmap = new boolean[95];
        for (int i = 0; i < s.length(); i++) {
            if (sMap[s.charAt(i) - ' '] == 0) {
                if (tmap[t.charAt(i) - ' '])return false;
                sMap[s.charAt(i) - ' '] = t.charAt(i);
                tmap[t.charAt(i) - ' '] = true;
            } else {
                if (sMap[s.charAt(i) - ' '] != t.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
