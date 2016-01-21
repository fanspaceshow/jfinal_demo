package com.demo.person;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator{
	
	protected void validate(Controller c) {
		validateRequiredString("person.LastName", "LastNameMsg", "请输入姓氏!");
 		validateRequiredString("person.FirstName", "FirstNameMsg", "请输入姓名!");
 		validateRequiredString("person.Address", "AddressMsg", "请输入地址!");	
 		validateRequiredString("person.City", "CityMsg", "请输入所在城市!");	
		
		validateLen(c);
	}

	public void validateLen(Controller c){
        if (c.getPara("person.City").equals("中国")) {
	          addError("CityMsg", "不存在这个城市！");
		}
       
	}
	protected void handleError(Controller c) {
		controller.keepModel(Person.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/form/save"))
			controller.render("add.jsp");
		else if (actionKey.equals("/form/update"))
			controller.render("edit.jsp");
		//c.renderJson();
	}
}
