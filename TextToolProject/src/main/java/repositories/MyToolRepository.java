/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import com.railtransme.entities.MyTool;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */

@Component
public interface MyToolRepository extends CrudRepository<MyTool, Long> {
    
    List<MyTool> findAll();
    List<MyTool> findAllByOrderByTagAsc();
    
    List<MyTool> findByTagLike(String name);
  
    
}
