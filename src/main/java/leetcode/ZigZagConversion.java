package leetcode;

/**
 * Created by fx on 2018/8/27.
 */
/**
 *
 * abcdefghijk
 *
 * a   e   i
 * b d f g j
 * c   g   k
 * aeibdfgjcgk
 */

public class ZigZagConversion {

    public String convert(String s,int numRows){

        int length = s.length();
        int clurse = 2*numRows-2;
        int start = 0;

        if(numRows==1) return s;



        StringBuffer stringBuffer = new StringBuffer();
        while (start<numRows){
            if(start==0||start==numRows-1){

                for(int i=0;i<s.length();i++){
                    //特殊的第一行和最后一行，差距正好为间隔数
                    if(i%clurse==start){
                        stringBuffer.append(s.charAt(i));

                    }
                }
            }else{
                for(int i=0;i<s.length();i++){
                    //竖边
                    if(i%clurse==start) {
                        stringBuffer.append(s.charAt(i));
                    }
                    //斜边
                    if(i%clurse==(clurse-start)){
                          stringBuffer.append(s.charAt(i));

                    }
                }

            }

            start++;
        }

        return stringBuffer.toString();
    }
}
