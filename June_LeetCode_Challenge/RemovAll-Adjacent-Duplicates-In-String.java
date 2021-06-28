class Solution {
    public String removeDuplicates(String s) {
        
        
        Stack<Character> st = new Stack<>();
        
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char ch = s.charAt(i);
            
            if(st.size()==0)
                st.push(ch);
            
            else
            {
                char pch = st.peek();
                if(ch==pch)
                {
                    st.pop();
                }
                else
                {
                    st.push(ch);
                }
            }
            
            
            
        }
        
        
        String str = "";
        while(st.size()>0)
        {
            str  = "" + st.pop() + str;
        }
        
        return str;
        
        
    }
}
