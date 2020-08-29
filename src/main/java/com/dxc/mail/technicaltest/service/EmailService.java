package com.dxc.mail.technicaltest.service;

import com.dxc.mail.technicaltest.vo.Email;

public interface EmailService {
      void send(Email email) throws  Exception;
}
