package olymtech.gateway.admin.controller;


        import olymtech.gateway.admin.websocket.UserChatCommand;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.messaging.handler.annotation.MessageMapping;
        import org.springframework.messaging.simp.SimpMessagingTemplate;
        import org.springframework.stereotype.Controller;

        import java.time.LocalDateTime;
        import java.util.Timer;
        import java.util.TimerTask;

@Controller
public class ChatAction {

    private SimpMessagingTemplate template;

    @Autowired
    public ChatAction(SimpMessagingTemplate t) {
        template = t;
    }

    @MessageMapping("/userChat")
    public void chat(UserChatCommand userChat) throws Exception {
        //找到需要发送的地址
        String dest = "/userChat/chat" + userChat.getCoordinationId();


        boolean flag = true;
        Timer timer = new Timer();
        timer.schedule(new MyTask(dest,userChat,template,flag), 1000, 2000);
    }

}

class MyTask extends TimerTask {

    private String dest;

    private UserChatCommand userChat;

    private SimpMessagingTemplate template;

    private boolean flag;


    public MyTask(String dest,UserChatCommand userChat ,SimpMessagingTemplate template,boolean flag){
        this.dest = dest;
        this.userChat = userChat;
        this.template = template;
        this.flag = flag;
    }

    @Override
    public void run() {

        //发送用户的聊天记录
        if(flag){
            userChat.setChatContent(userChat.getChatContent()+ LocalDateTime.now());
            template.convertAndSend(dest, userChat);
            flag = false;
        }




    }

}
