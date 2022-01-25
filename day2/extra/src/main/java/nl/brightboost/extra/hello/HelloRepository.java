package nl.brightboost.extra.hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelloRepository extends CrudRepository<Hello, Long> {
    List<Hello> findByDescription(String s);
    List<Hello> findAll();

    //approach for writing custom queries
//    @Query("SELECT * stuff FROM ...")
//    Hello customStuff();

}
