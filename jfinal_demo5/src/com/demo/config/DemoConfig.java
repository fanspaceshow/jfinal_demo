package com.demo.config;


import com.demo.controller.PersonController;
import com.demo.index.IndexController;
import com.demo.person.Person;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.AnsiSqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

/**
 * API引导式配置
 */
public class DemoConfig extends JFinalConfig{

	/**
	 * 读取数据库配置文件
	 */
	public void configConstant(Constants me) {
		PropKit.use("sqlconfig.txt");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setViewType(ViewType.JSP);
	}

	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add("/", IndexController.class, "/index");//
		me.add("/form", PersonController.class);
	}

	/**
	 * 配置数据库
	 */
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		        C3p0Plugin C3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim(),PropKit.get("driverClassName").trim());
				me.add(C3p0Plugin);
				
				// 配置ActiveRecord插件
				ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
				me.add(arp);
				arp.setDialect(new AnsiSqlDialect());//使用AnsiSqlDialect
				
				//选定表，第一列字段
				arp.addMapping("Persons","ID",Person.class);			    
	}

	
	public void configInterceptor(Interceptors me) {
		
		
	}

	
	public void configHandler(Handlers me) {
		
		
	}

}
