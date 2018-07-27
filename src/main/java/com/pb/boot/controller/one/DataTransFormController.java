package com.pb.boot.controller.one;

import com.pb.boot.service.one.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataTransFormController {

    DataService dataService;

    @GetMapping(value = "hello")
    public String helloWorld(){

        dataService.randomData();
        return "Hello World!";
    }

    /**
     * 从excel导入大量数据
     * 流实现低内存下读取大量数据和处理并存储大文件
     */

}
