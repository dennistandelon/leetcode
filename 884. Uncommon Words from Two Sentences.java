class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        ArrayList<String> toCheck1 = new ArrayList<String>(Arrays.asList(s1.split(" ")));
        ArrayList<String> toCheck2 = new ArrayList<String>(Arrays.asList(s2.split(" ")));
        
        int len1 = toCheck1.size();
        int len2 = toCheck2.size();
        ArrayList<String> result = new ArrayList<String>();
        
        ArrayList<String> duplicate = new ArrayList<String>();

        for(int i =0; i < len1; i++){
            if(result.indexOf(toCheck1.get(i)) > -1){
                duplicate.add(toCheck1.get(i));
                result.remove(result.indexOf(toCheck1.get(i))); 
            } else if(!(toCheck2.indexOf(toCheck1.get(i)) > -1 ) && !(duplicate.indexOf(toCheck1.get(i)) > -1)){
                result.add(toCheck1.get(i));
            }
        }

        for(int i =0; i < len2; i++){
            if(result.indexOf(toCheck2.get(i)) > -1){
                duplicate.add(toCheck2.get(i));
                result.remove(result.indexOf(toCheck2.get(i))); 
            } else if(!(toCheck1.indexOf(toCheck2.get(i)) > -1 ) && !(duplicate.indexOf(toCheck2.get(i)) > -1)){
                result.add(toCheck2.get(i));
            }
        }

        return result.toArray(new String[result.size()]);
    }
}