class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int total=0;
        int last_p=-1,last_m=-1,last_g=-1;
        for(int i=0;i<garbage.length;i++)
        {
            if(garbage[i].contains("G"))
            last_g=i;
            if(garbage[i].contains("P"))
            last_p=i;
            if(garbage[i].contains("M"))
            last_m=i;
            total+=garbage[i].length();
        }
        for(int i=0;i<travel.length;i++)
        {
            if(last_g!=-1 && last_g>i)
            total+=travel[i];
            if(last_m!=-1 && last_m>i)
            total+=travel[i];
            if(last_p!=-1 && last_p>i)
            total+=travel[i];
        }
        return total;
    }
}