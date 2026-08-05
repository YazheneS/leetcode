class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> st = new Stack<>();

        for (String comp : components) {
            if (comp.equals("") || comp.equals(".")) {
                continue;
            }

            if (comp.equals("..")) 
            {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } 
            else {
                st.push(comp);
            }
        }

        StringBuilder sb = new StringBuilder();
        //String sb="";
        /*while (!st.isEmpty()) 
        {
            sb.insert(0, "/" + st.pop());
            //sb+= "/" + st.pop();
        }*/
        for(String dir : st){
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();        
    }
}