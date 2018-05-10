package com.bynow.rei.third.mail;

import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:03 2018/5/8
 */
public class SendMailUtil {

    // 邮件发送协议
    private final static String PROTOCOL = "smtp";

    // SMTP邮件服务器
    private final static String HOST = "smtp.mxhichina.com";

    // SMTP邮件服务器默认端口
    private final static String PORT = "587";

    // 是否要求身份认证
    private final static String IS_AUTH = "true";

    // 是否启用调试模式（启用调试模式可打印客户端与服务器交互过程时一问一答的响应消息）
    private final static String IS_ENABLED_DEBUG_MOD = "true";

    // 发件人
    private static String from = "admin@bynowchn.com";

    // 初始化连接邮件服务器的会话信息
    private static Properties props = null;

    static {
        props = new Properties();
        props.setProperty("mail.transport.protocol", PROTOCOL);
        props.setProperty("mail.smtp.host", HOST);
        props.setProperty("mail.smtp.port", PORT);
        props.setProperty("mail.smtp.auth", IS_AUTH);
        props.setProperty("mail.debug",IS_ENABLED_DEBUG_MOD);
    }

    public static void sendEmail(String code,String to){
        try {
            // 创建Session实例对象
            Session session = Session.getDefaultInstance(props);
            // 创建MimeMessage实例对象
            MimeMessage message = new MimeMessage(session);
            // 设置邮件主题
            message.setSubject("欢迎注册REI管理后台");
            // 设置发送人
            message.setFrom(new InternetAddress(from));
            // 设置发送时间
            message.setSentDate(new Date());
            // 设置收件人
            message.setRecipients(RecipientType.TO, InternetAddress.parse(to));
            // 设置html内容为邮件正文，指定MIME类型为text/html类型，并指定字符编码为gbk
            message.setContent("<p>\n" +
                    "    <br/><img src=\"https://raw.githubusercontent.com/ByNow/rei/master/rei-admin/src/main/webapp/static/img/rei.jpg\"/>\n" +
                    "</p>\n" +
                    "<p>\n" +
                    "    欢迎注册REI管理后台\n" +
                    "</p>\n" +
                    "<p>\n" +
                    "    您此次的验证码是：<strong>"+code+"</strong>\n" +
                    "</p>","text/html;charset=utf-8");

            // 保存并生成最终的邮件内容
            message.saveChanges();

            // 发送邮件
            // 获得Transport实例对象
            Transport transport = session.getTransport();
            // 打开连接
            transport.connect("admin@bynowchn.com", "Bynow19940301");
            // 将message对象传递给transport对象，将邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            // 关闭连接
            transport.close();
        }catch (Exception e){
           e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        // 发送文本邮件
        //sendEmail();
    }
}
