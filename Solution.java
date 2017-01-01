import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        sc.useDelimiter("\\s*");
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int a[] = new int[N];
        int i = 0;
        
        while( i < N ) {
        	a[i++] = sc.nextInt();
        }
        int arr[][] = new int[N][N];

        boolean firstLargest;
        int current;
        int x = 0;
        int y = 0;
        
        int longestSequence = 0;
        
        for(i = 0; i < N-1; i++) {
        	current = a[i];
        	for(int j = i+1; j < N; j++) {
        		arr[x][y++] = a[i];
        		System.out.print(a[i] + " ");
        		int p = j;
        		int t = current;
        		firstLargest = true;
        		while( p < N ) {
        			if( current < a[p] ) {
        				arr[x][y++] = a[p];

        				if( firstLargest ) {
        					firstLargest = false;
        					j = p;
        				}

        				System.out.print(a[p] + " ");             
        				current = a[p];
        			}
        			p++;
        		}
        		
        		if(y > longestSequence)
        			longestSequence = y;
        		        		
        		y = 0;
        		x++;
        		System.out.println();
        		current = a[i];
        		
        	}
        }
        
        System.out.println("longest : " + longestSequence);
        

    }
}