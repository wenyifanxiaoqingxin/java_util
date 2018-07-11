package Demo.Test.Email;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Created by fx on 2018/2/6.
 */
public class sendMail {

    public static void main(String[] args) throws GeneralSecurityException {

        //收件人
        String toEmail = "1249756018@qq.com";

        //发件人
        String fromEmail = "1311083901@qq.com";

        //发送邮件主机
        String host = "smtp.qq.com";//qq邮箱服务器

        //获取系统属性
        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host",host);
        properties.setProperty("mail.smtp.port","465");
        properties.put("mail.smtp.auth","true");
        properties.setProperty("mail.user","1311083901");
        properties.setProperty("mail.password","pyalafxeyvmgfecc");

        MailSSLSocketFactory sf = new MailSSLSocketFactory();

        sf.setTrustAllHosts(true);

        properties.put("mail.smtp.ssl.enable","true");

        properties.put("mail.smtp.ssl.socketFactory",sf);

        //获取session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1311083901@qq.com","yzdginhtjaaoiedg");//发件人邮箱密码
            }
        });

        MimeMessage mimeMailMessage = new MimeMessage(session);

        try {
            //set from头部头字段
            mimeMailMessage.setFrom(new InternetAddress(fromEmail));
            //set to 头部头字段  单个人
            mimeMailMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));

            //发送多个人 type:要被设置为 TO, CC 或者 BCC，这里 CC 代表抄送、BCC 代表秘密抄送、
//            InternetAddress[] internetAddress =InternetAddress.parse("2676177457@qq.com,1249756018@qq.com");
//            mimeMailMessage.addRecipients(Message.RecipientType.TO,internetAddress);

            BodyPart bodyPart = new MimeBodyPart();
            //set subject主题 头部头字段
            mimeMailMessage.setSubject("i am fx!");

            //具体消息体
            bodyPart.setText("你接收到了吗？这是抽奖的页面。试试我的小程序");

            //多重消息
            Multipart multipart = new MimeMultipart();
            //设置文本消息部分

            multipart.addBodyPart(bodyPart);

            //附件
            bodyPart = new MimeBodyPart();
            String fileName = "/Users/crionline/Desktop/学习/抽奖/prize.zip";
            DataSource source =new FileDataSource(fileName);

            bodyPart.setDataHandler(new DataHandler(source));
            bodyPart.setFileName(fileName);
            multipart.addBodyPart(bodyPart);

            mimeMailMessage.setContent(multipart);

            //发送消息
            Transport.send(mimeMailMessage);
            System.out.println("send successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
