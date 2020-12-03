package fpt.java.finalproject.controllers.user;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.java.finalproject.models.Recipient;
import fpt.java.finalproject.repositories.RecipientRepository;
import fpt.java.finalproject.response.UserObjectResponse;
import fpt.java.finalproject.response.UserResponse;
import fpt.java.finalproject.utils.utility;
import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping("/checkout")
public class RecipientController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RecipientRepository recipientRepository;

    @GetMapping("")
    public String add(ModelMap m) {

        Recipient r = new Recipient();
        m.addAttribute("object", r);
        return "user/layouts/checkoutForm";
    }

    @GetMapping("/done")
    public String done(ModelMap m, HttpServletRequest rs) {
        return "user/layouts/doneCheckout";
    }

    // Save new
    @PostMapping("/save")
    public String save(Recipient r, ModelMap m, HttpServletRequest rs)
            throws UnsupportedEncodingException, MessagingException {

        UserResponse res = new UserResponse();

        RandomString.make(64);
        String random_code = RandomString.make(64);
        String siteUrl = utility.getSiteUrl(rs);
        r.setVerification_code(random_code);
        sendVerificationEmail(r, siteUrl);
        r.setAppro(false);

        // Save recipiient
        try {
            recipientRepository.save(r);
        } catch (Exception ex) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        m.addAttribute("res", res);
        // Redirect to list page
        return "user/layouts/checkmail";
    }

    private void sendVerificationEmail(Recipient r, String siteUrl)
            throws UnsupportedEncodingException, MessagingException {

        String subject = "Xác nhận đơn hàng";
        String senderName = "SunfnShop";
        String mailContent = "<p>Gửi:" + "" + r.getName() + "</p>";
        mailContent += "<p>nếu bạn đặt đơn hàng này vui lòng xác nhận email.</p>";

        String verifyUrl = siteUrl + "/checkout/verify?code=" + r.getVerification_code();
        mailContent += "<h3><a href=\"" + verifyUrl + "\">Xác nhận</a></h3>";
        mailContent += "<p>Xin cảm ơn !!.</p>";

        MimeMessage mess = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mess);
        helper.setFrom("levii.reys@gmail.com", senderName);
        helper.setTo(r.getEmail());
        helper.setSubject(subject);
        helper.setText(mailContent, true);
        mailSender.send(mess);
    }

    public boolean verify(String code) {
        Recipient r;
        r = recipientRepository.findRecipientByVerificationCode(code);
        if (r != null) {
            r.setAppro(true);
            recipientRepository.save(r);
            return true;
        }
        return false;
    }

    @GetMapping("/verify")
    public String verifySucsses(@RequestParam(required = true) String code, Model model) {
        boolean verify = verify(code);
        String pageTitle = verify ? "Đã xác nhận thành công, cảm ơn bạn đã sử dụng dịch vụ" : "đặt hàng thất bại";
        model.addAttribute("pagetitle", pageTitle);

        return "user/layouts/mess";
    }
    @RequestMapping("/checkmail")
    public String checkmail(){
        return "user/layouts/checkmail";
    }
}
