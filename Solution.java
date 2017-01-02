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
        
        
        int arr[][] = new int[(int) Math.pow(2, N)][N];

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
        
        
        int t2[] = new int[(int)Math.pow(2, N)];
        x = 0;
        y = 0;
        int p = longestSequence-1;
        int sum = 0;
        int k = 0;
        
        while(arr[x][0] != 0){		// x loops here
        	while(arr[x][y] != 0) {		// y loops here for each row
        		t2[k] = t2[k] + arr[x][y]*(int)Math.pow(10, p);
        		p--;        		        		
        		y++;
        	}
        	if(y != longestSequence) {
        		t2[k] = 0;
        	} else {
        		k++;
        	}
        	x++; 
        	y = 0;
        	p = longestSequence-1;
        }
        
        int temp[] = new int[k];
        for(int r = 0; r < k; r++)
        	temp[r] = t2[r];
        
        Arrays.sort(temp);
        
        if(k >= K) {
        	String s = temp[K-1] + "";
        	char number[] = s.toCharArray();
        	for(char c : number)
        		System.out.print(c + " ");
        	
        	
        } else {
        	System.out.println("-1");
        }

    }
}