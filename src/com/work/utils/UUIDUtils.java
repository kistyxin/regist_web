package com.imooc.utils;
import java.util.UUID;
public class UUIDUtils {
	//��UUID��������ʼ��ļ�����
  public static String getUUID() {
	return UUID.randomUUID().toString().replace("-","" );
}
  
}
