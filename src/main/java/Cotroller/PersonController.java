package Cotroller;

import Service.PersonService;
import org.springframework.stereotype.Controller;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Created by yuyang21 on 2016/11/30.
 */
@Controller
public class PersonController {
    @Resource
    public PersonService personService;
    @Test
    public void doSome(){
        System.out.print(personService.processSave());
    }
}
