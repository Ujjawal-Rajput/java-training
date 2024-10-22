class Solution {
    private static boolean isValid(String elem){
        if (elem.isEmpty()) {
            return false;
        }

        int hy = 0;
        int pun = 0;
        for (int i = 0; i < elem.length(); i++) {
            char c = elem.charAt(i);

            if (Character.isDigit(c)) {
                return false;
            }

            if (c == '-') {
                hy++;
                if (hy > 1 || i == 0 || i == elem.length() - 1 || !Character.isLowerCase(elem.charAt(i - 1)) || !Character.isLowerCase(elem.charAt(i + 1))) {
                    return false;
                }
            }

            if (c == '!' || c == '.' || c == ',') {
                pun++;
                if (pun > 1 || i != elem.length() - 1) {
                    return false;
                }
            }
        }

        return true;

    }
    public int countValidWords(String s) {
        String[] arr = s.split(" ");
        int count = 0;

        for(String elem : arr){
            if(isValid(elem)){
                count++;
            }
        }
        return  count;
    }
}










// class Solution {
//     public int countValidWords(String s) {
//         // a-z
//         // 0-9
//         // -, !, ., ,
//         int w = 0;
//         String arr[] = s.split(" ");
//         // w = arr.length;

//         s = s.trim();
//         for(int i=0; i<s.length()-1; i++){
//             // if (s.charAt(i) == ' ') w++;
//             if (s.charAt(i) == ' ' && s.charAt(i+1) != ' ') w++;
//         }

//         for(int i = 0; i<arr.length; i++){
//             int hy = 0;
//             int pu = 0;

//             int siz = arr[i].length();
//             for(int j=0; j<siz; j++){
//                 if (s.charAt(i) == '-') hy++;
//                 if (s.charAt(i) == '!' || s.charAt(i) == '.' || s.charAt(i) == ',') pu++;

//                 if (s.charAt(0)=='-' || s.charAt(siz-1)=='-' || hy > 1 || pu > 1 || (s.charAt(j)>='0' && s.charAt(j)<='9') || (s.charAt(j)>='A' && s.charAt(j)<='Z') || s.charAt(0)=='.' || s.charAt(0)=='!' || s.charAt(0)==',' || s.charAt(siz-1)=='.' || s.charAt(siz-1)=='!' || s.charAt(siz-1)==','){
//                     w--;
//                     break;
//                 }
//             }

//         }
//         return w;


//     }
// }