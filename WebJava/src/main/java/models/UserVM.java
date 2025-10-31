package models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import services.HelloService;

import java.util.Locale;

@Component
public class UserVM {

    // Properties: username, hello (read only)
    private String userName;

    // ============================

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public String getHello() {
//        return (getUserName() == null || getUserName().isEmpty() ? "Привет!" :
//                String.format("Привет, %s!", getUserName()));
//    }

/*    @Autowired
    private MessageSource messageSource;

    public String getHello() {

        String hello = messageSource.getMessage("header_hello", null, Locale.getDefault());

        return (getUserName() == null || getUserName().isEmpty() ? hello :
                messageSource.getMessage("header_hello_username",
                        new Object[] { getUserName() },
                        Locale.getDefault())
        );
    }*/

    @Autowired
    private HelloService helloSrv;

    public String getHello() {
        return helloSrv.getHello(getUserName());
    }

    // ============================
}
