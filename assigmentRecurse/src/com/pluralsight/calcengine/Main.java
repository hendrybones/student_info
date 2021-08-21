package com.pluralsight.calcengine;

public class Main {

    public int lowerString(String str) {

        if(str == null || str.isEmpty())
            return 0;
/*
        if (str.length() == 0) {
            return 0;
        }
*/
        int count = 0;
        if (str.charAt(0) == 'x')
        {
            count++;
        }
        return count + lowerString(str.substring(1));
//        return (str.charAt(0) == 'x' ? 1 : 0) + lowerString(str.substring(1));
    }
    public static int triangleBlock(int row){
        if (row==0)
            return 0;
        else
        {
            return row+ triangleBlock(row-1);
        }
    }

    public static void main(String[] args) {
        // write your code here
    }
    public static int StringCheck(String text,String key){
        //base condition
        if (!text.contains(key) || key.isEmpty())
            return 0;
        //actual work
        int keyLength=key.length();
        String firstKeyStringLen=text.substring(0,keyLength);
        int keyCount=0;
        System.out.println(firstKeyStringLen + ": "+ key);
        if (firstKeyStringLen.equals(key)){
            keyCount++;
            text=text.substring(keyLength);
        }
        else {
            text=text.substring(1);
        }

        return  keyCount+StringCheck(text,key);
    }

    public  String parenthesis(String str, String key)
    {
        if (str==null ||str.isEmpty())
            return str;
        else  if (str.equals(key))
        {
            return parenthesis(str,key);
        }
        return key;

    }
    public String StrCount(String str){
        if (str.length()<=1)
            return str;
        if (str.charAt(0)==str.charAt(1))
        {
            return Character.toString(str.charAt(0)) +"*"+StrCount(str.substring(1));
        }
        else {
            return Character.toString(str.charAt(0) )+StrCount(str.substring(1));
        }
    }
}
