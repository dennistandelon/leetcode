class Solution {
public:
    string reverseVowels(string s) {
        int len = s.length();

        int back = len - 1;

        vector<int> vowels_loc;
        
        int k = 0;
        string res = "";

        for(int i=0; i < len; i++){
            if(isVowel(s.at(i))){
                vowels_loc.push_back(i);
                k++;
            }
            res.insert(i,1,s.at(i));
        }

        for(int i=0; i < k; i++){
            res.erase(vowels_loc[i],1);
            res.insert(vowels_loc[i],1,s.at(vowels_loc[k-i-1]));
        }

        return res;
    }

    bool isVowel(char x){
        
        if(x == 'A' || x == 'I' || x == 'U' || x == 'E' || x == 'O'
        || x == 'a' || x == 'i' || x == 'u' || x == 'e' || x == 'o'){
            return true;
        }
        return false;
    }
};