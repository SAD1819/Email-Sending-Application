package io.github.sad1819.portfolio_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.sad1819.portfolio_project.model.PortfolioProject;
import io.github.sad1819.portfolio_project.model.PortfolioProjectEntity;
import io.github.sad1819.portfolio_project.repository.PortfolioProjectRepository;

@RestController
public class PortfolioProjectController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PortfolioProjectRepository portfolioProjectRepository;

    @Value("${spring.mail.username}")
    private String fromEmail; // Use the username as the 'from' email address

    @PostMapping("/send-email")
    public Response sendEmail(@RequestBody PortfolioProject form) {
        try {
            // Save to database
            PortfolioProjectEntity entity = new PortfolioProjectEntity();
            entity.setFullName(form.getFullName());
            entity.setEmail(form.getEmail());
            entity.setSubject(form.getSubject());
            entity.setMessage(form.getMessage());
            entity.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
            portfolioProjectRepository.save(entity);

            // Send email
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("dsaurabh1819@gmail.com");
            message.setFrom(fromEmail); // Set the 'from' email address
            message.setSubject("Contact Form: " + form.getSubject());
            message.setText("Name: " + form.getFullName() + "\nEmail: " + form.getEmail() + "\n\nMessage:\n" + form.getMessage());

            mailSender.send(message);

            return new Response(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false);
        }
    }

    public static class Response {
        private boolean success;

        public Response(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }
    }
}
