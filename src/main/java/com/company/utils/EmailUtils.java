package com.company.utils;



public class EmailUtils {

//    private static Logger log = LogManager.getLogger(EmailUtils.class);
//
//    private static String emailSubject = "subject";
//    private static String emailText = "textbody";
//    private static String emailTo = "@gmail";
//
//    private static final String smtpfromemail = "@gmail";
//    private static final String smtpport = "number(00)";
//    private static final String smtpserver = "blabla.net";
//
//
//    public static void sendMail(String emailTo, String emailSubject, String emailText){
//        Properties props = new Properties();
//
//        props.put("mail.smtp.host", smtpserver);
//        props.put("mail.smtp.port", smtpport);
//        Session session = new Session.getInstance(props,null);
//
//        try{
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(smtpfromemail));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
//            message.setSubject(emailSubject);
//            message.setText(emailText);
//            Transport.send(message);
//            log.info("The email is sent");
//        }catch (Exception e){
//
//        }
//    }
//
//    public static void sendMail(){
//        sendMail(emailTo,emailSubject,emailText);
//    }

}
