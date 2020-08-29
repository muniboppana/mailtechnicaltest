package com.dxc.mail.technicaltest.vo;

public class Email {
    private String fromAddress;
    private String toAddress;
    private String mailContent;
    private String ccAddress;
    private String bccAddress;
    private String subject;
    private String password;
    private boolean isHtml;
    private boolean isInternalServer;
    public String domainName;

    public Email(String fromAddress, String toAddress, String mailContent, String ccAddress, String bccAddress, String subject, String password, boolean isHtml,boolean isInternalServer, String domainName) {

        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.mailContent = mailContent;
        this.ccAddress = ccAddress;
        this.bccAddress = bccAddress;
        this.subject = subject;
        this.password = password;
        this.isHtml = isHtml;
        this.isInternalServer = isInternalServer;
        this.domainName = domainName;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(String ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String getBccAddress() {
        return bccAddress;
    }

    public void setBccAddress(String bccAddress) {
        this.bccAddress = bccAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isHtml() {
        return isHtml;
    }

    public void setHtml(boolean html) {
        isHtml = html;
    }

    public boolean isInternalServer() {
        return isInternalServer;
    }

    public void setInternalServer(boolean internalServer) {
        isInternalServer = internalServer;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }


}
