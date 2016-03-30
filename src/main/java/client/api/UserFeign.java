package client.api;

import client.api.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by JiangZhe on 16/3/30.
 */
@FeignClient("olymtech-api-user")
@RequestMapping("/user")
public interface UserFeign {

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    User save(User user);

    @RequestMapping(method = RequestMethod.GET,value = "/findAll")
    List<User> findAll();

    @RequestMapping(method = RequestMethod.DELETE)
    void del(@RequestParam("id") Long id);
}
