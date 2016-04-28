package olymtech.gateway.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.*;

/**
 * Created by JiangZhe on 16/4/25.
 */
@Configuration
@EnableWebMvc
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/portfolio").withSockJS();
//    }
//
//    @Override
//    public void configureWebSocketTransport(WebSocketTransportRegistration webSocketTransportRegistration) {
//
//    }
//
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration channelRegistration) {
//
//    }
//
//    @Override
//    public void configureClientOutboundChannel(ChannelRegistration channelRegistration) {
//
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {
//
//    }
//
//    @Override
//    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {
//
//    }
//
//    @Override
//    public boolean configureMessageConverters(List<MessageConverter> list) {
//        return true;
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        System.out.println("服务器启动成功");
//        config.setApplicationDestinationPrefixes("/app");
//        config.enableSimpleBroker("/userChat", "/topic");
//    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/userChat","/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/coordination").withSockJS();
    }
}
