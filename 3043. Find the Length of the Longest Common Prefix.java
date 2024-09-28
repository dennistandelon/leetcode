class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();

        for(int x: arr1){
            insert(root, String.valueOf(x));
        }

        int max = 0;
        for(int x: arr2){
            max = Math.max(max, findMax(root,String.valueOf(x)));
        }

        return max;
    }

    public void insert(TrieNode root, String num){
        int len = num.length();
        TrieNode curr = root;
        for(int i=0; i < len; i++){
            int c = num.charAt(i) - '0';
            if(curr.child[c] == null){
                curr.child[c] = new TrieNode();
            }
            curr = curr.child[c];
        }
        curr.wordEnd = true;
    }

    public int findMax(TrieNode root, String num){
        int len = num.length();
        TrieNode curr = root;
        int lenx = 0;
        for(int i=0; i < len; i++){
            int c = num.charAt(i) - '0';
            if(curr.child[c] != null){
                lenx++;
            } else{
                break;
            }
            curr = curr.child[c];
        }

        return lenx;
    }
}

public class TrieNode{
    public TrieNode[] child;
    public boolean wordEnd;

    public TrieNode(){
        wordEnd = false;

        child = new TrieNode[10];
    }

}