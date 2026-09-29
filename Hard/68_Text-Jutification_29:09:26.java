class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // may use an array to store word 
        List<String> jt = new ArrayList<>();

        int chars = 0;
        int start = 0;
    
        for(int i = 0; i<words.length; i++){
            if(i == 0){
                chars = words[i].length();
                start = i;
            } else if (chars + words[i].length() + 1 > maxWidth){
                if(start==i-1) jt.add(justifyLastLine(start, i-1, maxWidth, words));
                else jt.add(justifyString(start, i-1, maxWidth-chars, words));
                chars = words[i].length();
                start = i;

            } else {
                chars += words[i].length() + 1;           
            }
        }

        jt.add(justifyLastLine(start, words.length-1, maxWidth, words));

        return jt;
    }

    public String justifyString(int start, int end, int spaces, String[] words){
        int pad = spaces / (end - start); // spazi per ogni gap
        int rest = spaces%(end-start); // spazzi aggiuntivi da usare a partire da sinistra
        
        StringBuilder s = new StringBuilder();

        for(int i = start; i<end; i++){
            s.append(words[i]).append(" ".repeat(pad+1));
            if(rest > 0) {
                s.append(" ");
                rest--;
            }
        }

        s.append(words[end]);
        return s.toString();
    }

    public String justifyLastLine(int start, int end, int maxWidth, String[] words){        
        StringBuilder s = new StringBuilder();

        for(int i = start; i<end; i++){
            s.append(words[i]).append(" ");
        }
        s.append(words[end]);
        int n = maxWidth-s.length();
        if(n>0){
            s.append(" ".repeat(n));
        }
        return s.toString();
    }
}