package com.demo.person;


import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class Person extends Model<Person>{
	
      public static final Person person = new Person();
      
      /**
  	 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
  	 */
  /*	public Page<Person> paginate(int pageNumber, int pageSize) {
  		return paginate(pageNumber, pageSize, "select *", "from persons order by id asc");
  	}*/
      public List<Person> findAll(){
    	  
    	  return person.find("select * from persons order by id asc");
      }
      public List<Person> findByCity(String str){
    	  
    	  return person.find("select * from persons  where City=? order by id asc",str);
      }
}
