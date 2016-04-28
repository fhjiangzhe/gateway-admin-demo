package olymtech.gateway.admin.controller;

import client.api.UserFeign;
import client.api.domain.User;
import olymtech.gateway.admin.websocket.UserChatCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JiangZhe on 16/3/30.
 */
@Controller
@RequestMapping("/olymtech_user")
public class UserController {

    @Autowired
    private UserFeign userFeign;

    private SimpMessagingTemplate template;

    @Autowired
    public UserController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map saveUser(User user){
        Map result = new HashMap<>();
        if(null != userFeign.save(user)){
            result.put("state","success");
            result.put("rows",userFeign.findAll());
        }
        return result;
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<User> all = userFeign.findAll();
        model.addAttribute("users",all);
        return "userList";
    }


    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public Map del(Long id){
            Map result = new HashMap<>();
            userFeign.del(id);
            result.put("state","success");
            result.put("rows",userFeign.findAll());

            return result;
    }

}
