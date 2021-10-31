import java.util.*;

class Solution {
	public static void main(String args[])
	{
		int a[] = new int[]{1,1,1};
		int k = 2;
		System.out.println(subarraySum(a,k));
	}
	
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int currsum = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            currsum += nums[i];
            if(currsum == k)
            {
                count++;
            }
            
            if(map.containsKey(currsum-k))
            {
                count += map.get(currsum-k);
            }
            
            Integer c = map.get(currsum);
            if(c==null)
            {
                map.put(currsum,1);
            }
            else
            {
                map.put(currsum,c+1);
            }
            
            
        }
        
        return count;
    }
}


// for(i = 0 to n-1)
//      for(j = i to n-1)


// t.c = O(n^2)


// -> O(n)

// HashMap => {key: value}
// keys cannot be repeated!!

// benefit of using hashmap -> insertion, deletion => O(1)
//                          -> search => O(1)

// -> suppose we have an array -> {2,4,6,3,6,5,6,3}

/*
[8,1,3,2,6,3,6,3,3] => [3,2,6,3] => s
                        [8,1,3,2,6,3] => x
                        [8,1] => y
                        -> x-y = s
                        
                        -> (x-s)

k = 6

-> number of subarrays = 4

currsum = 0
map<integer, integer>
count = 0

[8,1,3,2,6,3,6,3,3]
       1 2   3   4
 
 currsum = 35
 
 if(35==6) x
    count++
 
 if( map has key of 35-6 = 29) true
    count += get value of key (currsum-k) from map
 
 
 int c = get value of key (35) from map = null
 
 if(c==null) true
    add value of currsum key as 1
 else
    add 1 to the current value of key currsum
 
 
 
 map
 keys: values
 8      1
 9      1
 12     1
 14     1
 20     1
 23     1
 29     1
 32     1
 35     1
 

 count
 0
 1
 2
 3
 4
 
 [9,-3,7,-3,-4, 14]
                 ^
 k = 7
 
 cs = 20
 
 20==7 x
 
 20-7 = 13 true
 
 6 in map x
 
 map
 k: v
 9  1
 6  2
 13 1
 10 1
 
 count
 0
 1
 2
 
*/
