import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
       FastReader fr = new FastReader();
      
      int N = fr.nextInt();
      int[] arr = new int[N];
      for(int i =0; i<N; i++){
        arr[i] = fr.nextInt();
      }

      Arrays.sort(arr);

      int prev = 0;	
		  int sum = 0;	
				
		for(int i = 0; i < N; i++) {	
			sum += prev + arr[i];
			prev += arr[i];
		}
      
		System.out.println(sum);
    
      
  }

  
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public FastReader(String s) throws FileNotFoundException { br = new BufferedReader(new FileReader(new File(s))); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}
