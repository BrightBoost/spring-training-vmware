package nl.brightboost.extra.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    public void addHello(Hello hello){
        helloRepository.save(hello);
    }

    public List<Hello> getAll() {
        return helloRepository.findAll();
    }

    public List<Hello> getByDescription(String desc) {
        return helloRepository.findByDescription(desc);
    }
}
