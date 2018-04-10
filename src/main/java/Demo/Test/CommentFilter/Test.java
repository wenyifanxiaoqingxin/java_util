package Demo.Test.CommentFilter;

/**
 * Created by fx on 2018/3/14.
 */
public class Test {

    public static void main(String[] args) {
        String ss = "我草你妈，你他妈是傻逼吗？";


        CommentFilter commentFilter = new CommentFilter();
        String sensitiveWord= commentFilter.markSensitiveWord(ss,1);
        System.out.println(sensitiveWord);
    }
}
