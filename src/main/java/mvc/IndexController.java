package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {


    @RequestMapping(value = "/*", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request) {

        if (request.getParameter("RedirectToRssPage") != null) {
            return new ModelAndView("views/RssPage", "model", null);
        }

        return new ModelAndView("index.jsp", "model", null);
    }

}

