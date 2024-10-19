class Solution {
    public String longestDiverseString(int a, int b, int c) {
        String result = "";
        
        while (a > 0 || b > 0 || c > 0) {
            int len = result.length();
            
            if (len >= 2 && result.charAt(len - 1) == result.charAt(len - 2)) {
                if (result.charAt(len - 1) == 'a') {
                    if (b >= c && b > 0) {
                        result += "b";
                        b--;
                    } else if (c > 0) {
                        result += "c";
                        c--;
                    } else {
                        break;
                    }
                } else if (result.charAt(len - 1) == 'b') {
                    if (a >= c && a > 0) {
                        result += "a";
                        a--;
                    } else if (c > 0) {
                        result += "c";
                        c--;
                    } else {
                        break;
                    }
                } else {
                    if (a >= b && a > 0) {
                        result += "a";
                        a--;
                    } else if (b > 0) {
                        result += "b";
                        b--;
                    } else {
                        break;
                    }
                }
            } else {
                if (a >= b && a >= c && a > 0) {
                    result += "a";
                    a--;
                } else if (b >= a && b >= c && b > 0) {
                    result += "b";
                    b--;
                } else if (c > 0) {
                    result += "c";
                    c--;
                } else {
                    break;
                }
            }
        }
        
        return result;

    }
}