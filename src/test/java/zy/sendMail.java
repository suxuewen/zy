package zy;

import org.junit.Test;
import com.zhiyou100.zy.web.utils.MailUtil;

public class sendMail {

	
	
	@Test
	public void sendMail1() throws Exception{
		
		MailUtil.send("1614795537@qq.com","哈哈哈哈", "你好啊");
		
	}
	
}
