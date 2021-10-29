import java.util.*;
class Solution {
    public static int lastStoneWeight(int[] stones) {
        int n = stones.length;
        
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return stones[0];
        }
        while(n>1)
        {
            Arrays.sort(stones);
            if(stones[n-1] == stones[n-2])
            {
                //stones[n-2] = 0; 
                if(n-2 == 0)
                {
                    return 0;
                }
                n = n-2;
            
            }
            else
            {
                stones[n-2] = stones[n-1] - stones[n-2];
                n--;
            }
        }
        return stones[0];
    }
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int a[] = new int[n];
    	for(int i=0;i<n;i++)
    	{
    		a[i] = sc.nextInt();
    	}
    	System.out.println(lastStoneWeight(a));
    }
}

// [2,7,4,1,8,1]
// n = length of the array
//while(n>1)  
    //sorting
    // [1,1,2,4,7,8]
    
    // a[n-1], a[n-2]
    // a[n-2] <= a[n-1]

    // newvalue = a[n-1] - a[n-2]

    // a[n-2] = newvalue

    // [1,1,2,4,1,8]  after sorting -> [1,1,1,2,4,8]
    // n--;
    

//return a[n-1] or a[0]


//Time Complexity will be O(n^2 log n)


/* [2,7,10,10]
-> [0,2,7,10]
-> [2,2,7,10]*/
