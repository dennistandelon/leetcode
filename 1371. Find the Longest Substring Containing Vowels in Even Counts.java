class Solution {
    public int findTheLongestSubstring(String s) {

        int len = s.length();

        int max = 0;
        int a, i, u , e, o;
        int tempA, tempI, tempU , tempE, tempO;

        a = 0;
        i = 0; 
        u = 0;
        o = 0;
        e = 0;

        for(int x = 0; x < len; x++){    
            char y = s.charAt(x); 
            if(y == 'e'){
                e++;
            } else if(y == 'a'){
                a++;
            }else if(y == 'i'){
                i++;
            }else if(y == 'u'){
                u++;
            }else if(y == 'o'){
                o++;
            }

            tempA = a;
            tempI = i;
            tempU = u;
            tempE = e;
            tempO = o;

            if(tempA % 2 == 0 && tempI % 2 == 0 && tempU % 2 == 0 && tempE % 2 == 0 && tempO % 2 == 0 && x + 1> max){
                    max = x + 1;
            }
            
            for(int j = 0; j <= x; j++){
                if(x - j < max){
                    break;
                }

                y = s.charAt(j); 
                if(y == 'e'){
                    tempE--;
                } else if(y == 'a'){
                    tempA--;
                }else if(y == 'i'){
                    tempI--;
                }else if(y == 'u'){
                    tempU--;
                }else if(y == 'o'){
                    tempO--;
                }

                if(tempA % 2 == 0 && tempI % 2 == 0 && tempU % 2 == 0 && tempE % 2 == 0 && tempO % 2 == 0 && x - j > max){
                    max = x - j;
                }
            }
        
        }

        return max;
    }
}