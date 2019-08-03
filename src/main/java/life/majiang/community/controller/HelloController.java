package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 黄明潘
 * @date 2019/8/3-14:12
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
