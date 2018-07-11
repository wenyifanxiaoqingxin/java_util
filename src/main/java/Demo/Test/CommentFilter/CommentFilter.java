package Demo.Test.CommentFilter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by fx on 2018/3/14.
 */
public class CommentFilter {

    private static Map sensitiveWordMap = null;
    public static int minMatchTYpe = 1; // 最小匹配规则
    public static int maxMatchType = 2; // 最大匹配规则
    public static String replaceChar = "*";

    public CommentFilter(){
        sensitiveWordMap = new DfaMethod().initKeyMap();
    }
    /**
     * 判断文字是否包含敏感字符
     * @param matchType
     *            匹配规则&nbsp;1：最小匹配规则，2：最大匹配规则
     */
    public boolean isContaintSensitiveWord(String txt, int matchType) {
        boolean flag = false;
        for (int i = 0; i < txt.length(); i++) {
            int matchFlag = this.CheckSensitiveWord(txt, i, matchType); // 判断是否包含敏感字符
            if (matchFlag > 0) { // 大于0存在，返回true
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 获取文字中的敏感词
     * @param matchType
     *            匹配规则&nbsp;1：最小匹配规则，2：最大匹配规则
     */
    public Set<String> getSensitiveWord(String txt, int matchType) {
        Set<String> sensitiveWordList = new HashSet<String>();
        for (int i = 0, size = txt.length(); i < size; i++) {
            int length = CheckSensitiveWord(txt, i, matchType); // 判断是否包含敏感字符
            if (length > 0) { // 存在,加入list中
                sensitiveWordList.add(txt.substring(i, i + length));
                i = i + length - 1; // 减1的原因，是因为for会自增
            }
        }
        return sensitiveWordList;
    }

    private String getReplaceChars(String replaceChar,int length){
        String resultReplace = replaceChar;
        for(int i = 1 ; i < length ; i++){
            resultReplace += replaceChar;
        }
        return resultReplace;
    }

    /**
     * 替换敏感字字符
     */
    public String replaceSensitiveWord(String txt, int matchType) {
        String resultTxt = txt;
        Set<String> set = getSensitiveWord(txt, matchType); // 获取所有的敏感词
        Iterator<String> iterator = set.iterator();
        String word = null;
        String replaceString = null;
        while (iterator.hasNext()) {
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }

        return resultTxt;
    }

    /**
     * 凸显修饰敏感字字符
     */
    public String markSensitiveWord(String txt, int matchType) {
        String resultTxt = txt;
        Set<String> set = getSensitiveWord(txt, matchType); // 获取所有的敏感词
        Iterator<String> iterator = set.iterator();
        String word = null;
        String replaceString = null;
        while (iterator.hasNext()) {
            word = iterator.next();
//            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceChar);
        }

        return resultTxt;
    }

    /**
     * 检查文字中是否包含敏感字符，检查规则如下
     * @return，如果存在，则返回敏感词字符的长度，不存在返回0
     */
    @SuppressWarnings({ "rawtypes" })
    public int CheckSensitiveWord(String txt, int beginIndex, int matchType) {
        boolean flag = false;
        int matchFlag = 0;
        char word = 0;
        Map nowMap = sensitiveWordMap;
        for (int i = beginIndex; i < txt.length(); i++) {
            word = txt.charAt(i);
            nowMap = (Map) nowMap.get(word);
            if (nowMap != null) {
                matchFlag++;
                if ("1".equals(nowMap.get("isEnd"))) {
                    flag = true;
                    if (CommentFilter.minMatchTYpe == matchType) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        if (matchFlag < 2 || !flag) {
            matchFlag = 0;
        }
        return matchFlag;
    }
}
