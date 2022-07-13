import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'compressWord' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING word
     *  2. INTEGER k
     */

    public static String compressWord(String word, int k) {
    // Write your code here
       class Pair {
            char c;
            int ctr;
            Pair(char c, int ctr){
                this.c = c;
                this.ctr = ctr;
             }
         }
         
         Stack<Pair> st = new Stack<Pair>();
         
         int l = word.length();
         int ctr = 0;
  
         for (int i = 0; i < l; i++) {
  
             if (st.size() == 0) {
                 st.push(new Pair(word.charAt(i), 1));
                 continue;
             }
  
             if (st.peek().c == word.charAt(i)) {
                 Pair p = st.peek();
                 st.pop();
                 p.ctr += 1;
                 if (p.ctr == k) {
                     continue;
                 }
                 else {
                     st.push(p);
                 }
             }
             else {
  
                 st.push(new Pair(word.charAt(i), 1));
             }
         }
  
         String ans = "";
         while (st.size() > 0) {
             char c = st.peek().c;
             int cnt = st.peek().ctr;
             while (cnt-- > 0)
                 ans = c + ans;
             st.pop();
         }
         return ans;
    }
}

public class Solution { 
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String word = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.compressWord(word, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
