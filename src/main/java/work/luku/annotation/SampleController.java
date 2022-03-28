package work.luku.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class SampleController {

    @SampleAnnotation
    @GetMapping
    @ResponseBody
    public String index() {
        return "sample response";
    }

    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:/";
    }

    @GetMapping("/call")
    @ResponseBody
    public String call() {
        return index();
    }

}
