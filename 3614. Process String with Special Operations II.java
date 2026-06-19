class Solution {
    public char processStr(String s, long k) {

        int strLen = s.length();
        long currLen = 0;
        long[] len = new long[strLen];

        for (int i = 0; i < strLen; i++) {
            char c = s.charAt(i);

            switch (c) {
                case '*':
                    currLen = Math.max(0L, currLen - 1);
                    break;

                case '#':
                    currLen *= 2;
                    break;

                case '%':
                    break;

                default:
                    currLen++;
            }

            len[i] = currLen;
        }

        if(k >= currLen) return '.';

        for (int i = strLen - 1; i >= 0; i--) {
            char c = s.charAt(i);

            long prevLen = (i == 0) ? 0 : len[i - 1];

            switch (c) {

                case '#':
                    k %= prevLen;
                    break;

                case '%':
                    k = prevLen - 1 - k;
                    break;

                case '*':
                    break;

                default:
                    if (k == prevLen) {
                        return c;
                    }
            }
        }

        return '.';
    }   
}