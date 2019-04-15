package mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:jiliang
 * @Date:2019/4/15
 * @Time:19:30
 */
public class UserController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setName("jiliang");

        userList.add(user);
        return new ModelAndView("userlist", "users", userList);
    }
}
