package com.ruchira.configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ruchira on 10/22/2020.
 */
@Controller
@RefreshScope
public class RateController {
    @Value("${rate}")
    String rate;
    @Value("${lanecount}")
    String lanecount;
    @Value("${tollstart}")
    String tollstart;

    @RequestMapping("/rate")
    public String getRate(Model model) {
        model.addAttribute("rateAmount", rate);
        model.addAttribute("laneCount", lanecount);
        model.addAttribute("tollStart", tollstart);

        //name of the view
        return "rateView";
    }
}
