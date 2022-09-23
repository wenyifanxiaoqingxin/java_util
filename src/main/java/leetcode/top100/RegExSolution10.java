package leetcode.top100;

/**
 * @author fanxiao3
 * @className RegExSolution
 * @description 正则匹配
 * @date 2022/9/23 1:55 下午
 */
public class RegExSolution10 {

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        if(m == 0 &&  n == 0 ){
            return true;
        }
        if(m == 0 || n == 0){
            return false;
        }

        boolean[][]  temp = new boolean[m+1][n+1];
        temp[0][0] = true ;
        for(int i=0;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(p.charAt(j-1) == '*'){
                    temp[i][j] = temp[i][j-2];
                    if(isMatchChar(s,p,i,j-1)){
                        temp[i][j] = temp[i][j] || temp[i-1][j];
                    }
                }else{
                    if(isMatchChar(s,p,i,j)){
                        temp[i][j] = temp[i-1][j-1];
                    }
                }
            }

        }
        return temp[m][n];
    }

    private static boolean isMatchChar(String s,String p,int i ,int j){
        if(i == 0){
            return false;
        }
        if(p.charAt(j-1) == '.'){
            return true;
        }
        return p.charAt(j-1) == s.charAt(i-1);
    }

    public static void main(String[] args) {
        String s = "aa";
        String p= ".*";
        System.out.println(isMatch(s,p));
    }
}
