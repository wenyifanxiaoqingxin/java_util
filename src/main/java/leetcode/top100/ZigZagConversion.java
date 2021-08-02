package leetcode.top100;

/**
 * @description: some desc
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/2 10:55 上午
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if(numRows ==1){
            return s;
        }
        String []convertArray= new String[numRows-1];
        for(int i=0;i<s.length();i++){
            if(i/(numRows-1)%2 ==0){
                convertArray[i%(numRows-1)]+=s.charAt(i);
            }else{
                convertArray[numRows-(i%(numRows-1))-1]+=s.charAt(i);
            }
        }
        return convertArray.toString();
    }

    public static void main(String[] args) {
        String s ="PAYPALISHIRING";
        System.out.println(convert(s,3));
    }
}
