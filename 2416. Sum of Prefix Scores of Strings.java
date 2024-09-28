class Solution {
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();

        for(String str : words){
            InsertTrie(root,str);
        }

        int len = words.length;
        int[] arr = new int[len];

        for(int i = 0; i < len; i++){
            arr[i] = find(root,words[i]);
        }

        return arr;
    }

    public void InsertTrie(TrieNode root, String str){

        TrieNode curr = root;
        for(char x: str.toCharArray()){
            int pos = x - 'a';
            if(curr.child[pos] == null){
                curr.child[pos] = new TrieNode();
            }
            curr.child[pos].count++;
            curr = curr.child[pos];
        }

        curr.end = true;
    }

    int find(TrieNode root, String str){
        TrieNode curr = root;
        int res = 0;
        for(char x: str.toCharArray()){
            int pos = x - 'a';
            curr = curr.child[pos];
            res = res + curr.count;
        }

        return res;
    }
}

class TrieNode{
    TrieNode[] child;
    boolean end;
    int count;

    public TrieNode(){
        end = false;
        count = 0;
        child = new TrieNode[26];
    }
}