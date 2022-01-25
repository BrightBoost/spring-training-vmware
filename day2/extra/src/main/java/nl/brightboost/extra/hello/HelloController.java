package nl.brightboost.extra.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @PostMapping
    public void addHello(@RequestBody Hello hello){
        helloService.addHello(hello);
        System.out.println(hello.getDescription() + "  id: " + hello.getId());
    }

    @GetMapping("all")
    public List<Hello> getAll() {
        return helloService.getAll();
    }

    @PostMapping("desc")
    public List<Hello> getAllByDesc(@RequestBody String description) {
        return helloService.getByDescription(description);
    }


}
