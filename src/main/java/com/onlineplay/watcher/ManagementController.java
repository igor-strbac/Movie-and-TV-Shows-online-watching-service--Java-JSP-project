/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Anđelka
 */

@Controller
@RequestMapping("management")
public class ManagementController {

    @GetMapping("index")
    public String index(){
        return "management/index";
    }
}
