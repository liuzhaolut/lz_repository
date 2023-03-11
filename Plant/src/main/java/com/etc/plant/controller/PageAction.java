package com.etc.plant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制层
 * @author lz
 */
@Controller
public class PageAction {
    /**
     * 页面跳转
     * @param go
     * @return
     */
    @RequestMapping("/go")
    public String go(String go){
        return go;
    }


}
