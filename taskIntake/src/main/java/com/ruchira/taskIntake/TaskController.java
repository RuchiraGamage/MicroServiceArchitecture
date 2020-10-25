package com.ruchira.taskIntake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ruchira on 10/25/2020.
 */
@RestController
public class TaskController {

    @Autowired
    private TaskProcessor t;

    //pass in POST payload values
    @RequestMapping(path = "/tasks", method = RequestMethod.POST)
    public @ResponseBody
    String launchTask(@RequestBody String s) {

        //t.publishRequest(s);

        System.out.println("request made");

        return "success";
    }
}
