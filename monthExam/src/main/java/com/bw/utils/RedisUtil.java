package com.bw.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;


import redis.clients.jedis.Jedis;

public class RedisUtil {
	public static void setRedis(String key,Object obj)
	{
		Jedis jedis = new Jedis("192.168.162.129",6379);
		jedis.set(key.getBytes(), toBytes(obj));
	}
	
	public static Object getRedis(String key)
	{
		Jedis jedis = new Jedis("192.168.162.129",6379);
		boolean isExists = jedis.exists(key.getBytes());
		if(isExists)
		{
			byte[] data = jedis.get(key.getBytes());
			return toObject(data);
		}
		else
			return null;
	}
	
	public static void delRedis(String key)
	{
		Jedis jedis = new Jedis("192.168.162.129",6379);
		jedis.del(key.getBytes());
	}
	
	public static Set<String> listKey(String pattern)
	{
		Jedis jedis = new Jedis("192.168.162.129",6379);
		return jedis.keys(pattern);
	}
	
	//将对象序列为字节数组
	public static byte[] toBytes(Object obj)
	{
		try
		{
			//定义字节数组输出流
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//定义对象输出流，包装字节数组输出流
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			//通过对象输出流输出对象的内存结构
			oos.writeObject(obj);
			//字节数组输出流获取字节数组
			byte[] data = baos.toByteArray();
			oos.close();
			baos.close();
			return data;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	//将字节数组反序列化为对象
	public static Object toObject(byte[] data)
	{
		try
		{
			//根据字节数组定义字节数组输人流
			ByteArrayInputStream bais = new ByteArrayInputStream(data);
			//包装对象输入流
			ObjectInputStream oii = new ObjectInputStream(bais);
			//从流中读取对象
			Object obj = oii.readObject();
			oii.close();
			bais.close();
			return obj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	

}
