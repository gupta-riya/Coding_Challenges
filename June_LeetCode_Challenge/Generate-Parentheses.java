// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

class Solution {
    
    public void helperFunc(int n, int op, int cl, ArrayList<String>list, String psf)
    {
        if(n*2 == psf.length())
        {
            list.add(psf);
            return;
        }
        
        if(op < n)
            helperFunc(n,op+1,cl,list,psf+'(');
        
        
        if(cl < op)
            helperFunc(n,op,cl+1,list,psf+')');
        
    }
   
    public List<String> generateParenthesis(int n) {
        
        
        ArrayList<String> list = new ArrayList<>();
        helperFunc(n,0,0,list,"");
        return list;
        
    }
}
