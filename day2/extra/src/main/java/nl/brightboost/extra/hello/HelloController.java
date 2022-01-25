package nl.brightboost.extra.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value="post", method = RequestMethod.POST)
    public void addHello(@RequestBody Hello hello){
        helloService.addHello(hello);
        System.out.println(hello.getDescription() + "  id: " + hello.getId());
    }
}
