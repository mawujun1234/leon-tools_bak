package test.mawujun.utils.string;

import org.apache.commons.text.similarity.CosineDistance;
import org.junit.Test;

public class StringEscapeUtilsTest {
	@Test
	public void test() {
		//StringEscapeUtils.
		
		
		CosineDistance cosineDistance=new CosineDistance();
		Double d=cosineDistance.apply("1111","中国");
		System.out.println(d);
	}

}
