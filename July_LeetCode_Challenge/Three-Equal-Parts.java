
// You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such that all of these parts represent the same binary value.

// If it is possible, return any [i, j] with i + 1 < j, such that:

// arr[0], arr[1], ..., arr[i] is the first part,
// arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
// arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
// All three parts have equal binary values.
// If it is not possible, return [-1, -1].

// Note that the entire part is used when considering what binary value it represents. For example, [1,1,0] represents 6 in decimal, not 3. Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.

 





class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        
        int countOne = 0;
        int n = arr.length;
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i] == 1)
                countOne++;
        }
        
        if(countOne%3!=0)
            return new int[]{-1,-1};
        
        int t = countOne/3;
        
        if(t == 0)
        {
            return new int[]{0,n-1};
        }
      
        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;
        int su = 0;
        
        for (int i = 0; i < n; ++i) {
            
            if (arr[i] == 1) {
                su += 1;
                if (su == 1) i1 = i;
                if (su == t) j1 = i;
                if (su == t+1) i2 = i;
                if (su == 2*t) j2 = i;
                if (su == 2*t + 1) i3 = i;
                if (su == 3*t) j3 = i;
            }
        }
            
        int[] part1 = Arrays.copyOfRange(arr, i1, j1+1);
        int[] part2 = Arrays.copyOfRange(arr, i2, j2+1);
        int[] part3 = Arrays.copyOfRange(arr, i3, j3+1);

        if (!Arrays.equals(part1, part2)) return new int[]{-1,-1};
        if (!Arrays.equals(part1, part3)) return new int[]{-1,-1};

        // x, y, z: the number of zeros after part 1, 2, 3
        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = arr.length - j3 - 1;

        if (x < z || y < z) return new int[]{-1,-1};
        return new int[]{j1+z, j2+z+1};
        
        
    }
}
