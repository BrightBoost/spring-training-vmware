package nl.brightboost.extra.hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelloRepository extends CrudRepository<Hello, Long> {
    List<Hello> findByDescription(String s);

}
