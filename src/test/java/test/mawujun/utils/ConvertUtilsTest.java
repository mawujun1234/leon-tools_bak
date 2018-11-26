package test.mawujun.utils;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import org.junit.Test;

import com.mawujun.utils.ConvertUtils;

import test.mawujun.utils.model.Sex;

public class ConvertUtilsTest {
	SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat yyyyMMddHHmmss=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat HHmmss=new SimpleDateFormat("HH:mm:ss");
	@Test
	public void test() {
		BigDecimal a=(BigDecimal)ConvertUtils.convert("1", BigDecimal.class);
		assertEquals(new BigDecimal(1), a);
		
		Float b=(Float)ConvertUtils.convert("1.1", Float.class);
		assertEquals(new Float(1.1), b);
		
		Object b1=ConvertUtils.convert("1.1", Float.class);
		assertEquals(new Float(1.1), b1);
		
		Sex sex=(Sex)ConvertUtils.convert("Man", Sex.class);
		assertEquals(Sex.Man, sex);
		
		//Date now=new Date();
		Date date=(Date)ConvertUtils.convert("2018-11-26", Date.class);
		assertEquals("2018-11-26", yyyyMMdd.format(date));
		assertEquals("2018-11-26 00:00:00", yyyyMMddHHmmss.format(date));
		
		date=(Date)ConvertUtils.convert("2018-11-26 11:11:11", Date.class);
		assertEquals("2018-11-26", yyyyMMdd.format(date));
		assertEquals("2018-11-26 11:11:11", yyyyMMddHHmmss.format(date));
		assertEquals("11:11:11", HHmmss.format(date));
		
		date=(Date)ConvertUtils.convert("11:11:11", Date.class);
		assertEquals("11:11:11", HHmmss.format(date));
		
	}

}
