package sds_algorithm.src.DAY04.BJ2824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class BJ2824 {
    static BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = 
            new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String args[]) throws IOException{
        // Scanner sc = new Scanner(System.in);
    	int n, m, i, j, GCD, mod = 1000000000, flag = 0;
    	long ans = 1;
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	int[] A = new int[n];
    	st = new StringTokenizer(br.readLine(), " ");
    	for(i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(br.readLine());
    	int[] B = new int[m];
    	st = new StringTokenizer(br.readLine(), " ");
    	for(i = 0; i < m; i++) B[i] = Integer.parseInt(st.nextToken());
    	for(i = 0; i < m; i++){
    		for(j = 0; j < n; j++){
    			GCD = gcd(A[j], B[i]);
    			ans *= GCD;
    			if(ans >= mod){
    				ans %= mod;
    				flag = 1;
    			}
    			A[j] /= GCD;
    			B[i] /= GCD;
    			if(B[i] == 1) break;
    		}
    	}
    	if(flag == 0) bw.write(ans+"");
    	else{
    		for(i = mod/10; i >= 1; i /= 10) bw.write((ans/i)%10+"");
    	}
        bw.close();
    }
    
    static int gcd(int a, int b){
    	if(b==0) return a;
    	else return gcd(b, a%b);
    }
}