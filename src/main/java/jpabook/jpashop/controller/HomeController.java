package jpabook.jpashop.controller;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {

    // = @Slf4j
    // Logger log = LoggerFactory.getLogger(HomeController.class);

    /**
     * 홈
     * @return
     */
    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "home";
    }
    
}
