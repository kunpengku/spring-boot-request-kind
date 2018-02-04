package com.example.sth.springboot.demo;

import com.example.sth.springboot.demo.domain.Friend;
import org.springframework.web.bind.annotation.*;

/**
 * Description
 * <p>
 * </p>
 * DATE 2018/1/15.
 *
 * @author fupeng.
 */
@RestController
public class TestRequestController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    /**
     * RequestBody
     * @param friend
     * @return
     */
    @RequestMapping(value = "/friend", method = RequestMethod.POST)
    public String create(@RequestBody Friend friend) {
        System.out.println(friend);

        return "ok";
    }

    /**
     * PathVariable
     * @param friendId
     * @return
     */
    @GetMapping("/friend/{friendId}")
    public String findOwner(@PathVariable String friendId) {
        System.out.println(friendId);
        return "displayOwner";
    }

    /**
     * RequestParam
     * @param location
     * @param stage
     * @return
     */
    @GetMapping("/friend/me")
    public String findOwner(@RequestParam("location") String location,
                            @RequestParam("stage") String stage) {
        System.out.println(location);
        System.out.println(stage);
        return "displayOwner";
    }

    /**
     * RequestHeader
     * @param authorization
     * @param keepAlive
     */
    @GetMapping("/friend/me2")
    public void displayHeaderInfo(@RequestHeader("Authorization") String authorization,
                                  @RequestHeader("Keep-Alive") long keepAlive) {

        System.out.println(authorization);

    }

}
