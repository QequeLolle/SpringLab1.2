package controllers;

import models.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private UserVM userVM;

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Model uiModel) {

        uiModel.addAttribute("user", this.userVM);

        return "hello/form";  // /WEB-INF/views/hello/form.html - real path with template resolver
    }

    @RequestMapping(method = RequestMethod.POST)
    public String showHello(UserVM userVM, BindingResult bindingResult, Model uiModel) {

        this.userVM.setUserName(userVM.getUserName());

        uiModel.addAttribute("user", this.userVM);

        return "hello/form";
    }
}
