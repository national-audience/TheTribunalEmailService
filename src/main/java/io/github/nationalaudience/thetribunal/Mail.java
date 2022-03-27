package io.github.nationalaudience.thetribunal;

public class Mail {

    private String emailAddress;
    private String emailSubject;
    private String emailBody;

    public Mail(String emailAddress, String emailSubject, String emailBody) {
        this.emailAddress = emailAddress;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }
}
