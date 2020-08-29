package com.dxc.mail.technicaltest.service;

import com.dxc.mail.technicaltest.vo.Email;

public class EmailHelper {
    public static void main (String args[]) throws  Exception {

        EmailService emailService = new EmailServiceImpl();
        emailService.send(new Email("frommailaddress","tomailaddress","hello","","","Hello DXC","bergen",false,true,"internalDomain"));
        emailService.send(new Email("frommailaddress","tomailaddress","hello","","","<html><head><body></body></head></html>","bergen",false,false,"externalDomain"));


    }
}
