package com.imooc.utils;
import java.util.UUID;
public class UUIDUtils {
	//用UUID随机生成邮件的激活码
  public static String getUUID() {
	return UUID.randomUUID().toString().replace("-","" );
}
  
}
