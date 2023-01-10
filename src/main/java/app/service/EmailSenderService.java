package app.service;

import app.models.entities.Mail;

public interface EmailSenderService {
    void send(Mail mail);
}
