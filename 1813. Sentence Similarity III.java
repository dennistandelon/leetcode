class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int len1 = words1.length;
        int len2 = words2.length;

        int prefix = 0;
        while (prefix < len1 && prefix < len2 && words1[prefix].equals(words2[prefix])) {
            prefix++; 
        }

        int suffix = 0;
        while (suffix < len1 - prefix && suffix < len2 - prefix && words1[len1 - 1 - suffix].equals(words2[len2 - 1 - suffix])) {
            suffix++;  
        }

        return prefix + suffix >= Math.min(len1, len2);

    }
}