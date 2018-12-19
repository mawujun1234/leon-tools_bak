package test.mawujun.utils.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mawujun.http.HttpClientUtils;
import com.mawujun.utils.file.FileUtils;

import net.minidev.json.JSONObject;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HttpClientUtilsApplication.class,webEnvironment=WebEnvironment.RANDOM_PORT)
//@WebAppConfiguration
public class HttpClientUtilsTest {
	@LocalServerPort
	private int port;
	@Test
    public void testHome() throws Exception {
		String baseurl="http://localhost:"+port;
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("age", "111");
		params.put("name", "222");
		String result=HttpClientUtils.doGet(baseurl+"/doget", params);
		Assert.assertEquals("111222", result);
		
		result=HttpClientUtils.doPost(baseurl+"/dopost", params);
		Assert.assertEquals("111222", result);
		
		
		String paramStr=JSONObject.toJSONString(params);
		result=HttpClientUtils.doPostJson(baseurl+"/doPostJson", paramStr);
		Assert.assertEquals(paramStr, result);
		
		result=HttpClientUtils.doPostJson(baseurl+"/doPostJson1", paramStr);
		Assert.assertEquals("{\"age\":111,\"name\":\"222\"}", result);
		
		Map<String,Object> header=new HashMap<String,Object>();
		header.put("aaa", "333");
		header.put("bbb", "444");
		result=HttpClientUtils.doPostJson(baseurl+"/doPostJson2", header,paramStr);
		Assert.assertEquals("111222333444", result);
		
		File file=new File(FileUtils.getProjectPath()+"/src/test/java/test/mawujun/utils/http/HttpClientUtilsTest.java");
		result=HttpClientUtils.doPostFile(baseurl+"/doPostFile","file", file,params);
		Assert.assertEquals("111222HttpClientUtilsTest.java", result);
		
		Map<String,Object> aaaa=new HashMap<String,Object>();
		aaaa.put("file", file);
		aaaa.put("age", "111");
		aaaa.put("name", "222");
		result=HttpClientUtils.doPostFile(baseurl+"/doPostFile", aaaa);
		Assert.assertEquals("111222HttpClientUtilsTest.java", result);
		
		InputStream is=new FileInputStream(file);
		aaaa=new HashMap<String,Object>();
		aaaa.put("file", file);
		aaaa.put("file1", "aaaaa".getBytes());
		aaaa.put("file2", is);
		aaaa.put("age", "111");
		aaaa.put("name", "222");
		result=HttpClientUtils.doPostFile(baseurl+"/doPostFile1", aaaa);
		Assert.assertEquals("111222HttpClientUtilsTest.java", result);
     
    }
}
