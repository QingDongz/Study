package com.demo.springmvc.Controller;

import com.demo.springmvc.domain.Fruits;
import com.demo.springmvc.service.FruitsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FruitsController {

    private static final Logger logger = Logger.getLogger(FruitsController.class);

    @Autowired
    FruitsService fruitsService;


    @RequestMapping("/taglib")
    public String getAllFruits(Model model) {
        List<Fruits> fruits = fruitsService.getAllFruits();
        model.addAttribute("allFruits", fruits);
        logger.info("查出水果");
        return "/list";
    }
}
