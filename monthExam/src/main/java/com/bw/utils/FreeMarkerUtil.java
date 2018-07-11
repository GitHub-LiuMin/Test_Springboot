package com.bw.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import freemarker.cache.WebappTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerUtil {

	public static void generateHtml(ServletContext servletContext,
			String staticHtmlPath,String template,Map map)
	{
		try
		{
			//声明配置对象
			Configuration conf = new Configuration(Configuration.VERSION_2_3_23);
			conf.setEncoding(Locale.getDefault(), "UTF-8");
			//声明模板加载器
			WebappTemplateLoader wtl = new WebappTemplateLoader(servletContext, "/ftl");
			//绑定到配置对象
			conf.setTemplateLoader(wtl);
			Template tmplt = conf.getTemplate(template);
			//根据模板与数据模型生成静态网页
			String path = servletContext.getRealPath("/"+staticHtmlPath);
			String file = path+"/"+map.get("id")+".html";
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			tmplt.process(map, bw);
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
