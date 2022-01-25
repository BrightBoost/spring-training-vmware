package nl.brightboost.extra.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    public void addHello(Hello hello){
        helloRepository.save(hello);
    }
}
