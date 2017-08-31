package com.zhiyou100.util;

import org.junit.Test;

/**  
* @ClassName: MailTest  
* @Description: TODO
* @author lyb  
* @date 2017年8月28日  下午2:31:54
*  
*/
public class MailTest {

	@Test
	public void test01() throws Exception{
		/*
		 * 
		 * <a href=\"http://www.baidu.com\">百度</a>
		 */
		for(int i=0; i<10;i++){
			
			MailUtil.send("282059782@qq.com", "测试邮件", "炎帝");
		}
		
		/*
		 * 0. MD5(邮箱+密码+当前时间)就是激活码  24小时有效
		 * 1.id(uuid)  邮箱地址   状态(0未激活,1表示激活)   激活码     失效时间
		 * 2.http://localhost:8080/Test/Mail/active.action?id=id&activeCode=激活码 
		 */
		
		
		
	}
	
}
