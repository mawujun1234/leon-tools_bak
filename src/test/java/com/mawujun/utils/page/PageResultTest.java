package com.mawujun.utils.page;

import static org.junit.Assert.*;

import org.junit.Test;

public class PageResultTest {

	@Test
	public void test() {
		PageParam param=PageParam.getInstance(0, 10);
		
		PageResult result=new PageResult(param);
		result.setTotal(15);
		
		assertEquals(0, result.getStart());
		assertEquals(10, result.getLimit());
		assertEquals(1, result.getPageNo());	
		assertEquals(15, result.getTotal());
		assertEquals(0,result.getResultSize());
		assertEquals(2,result.getTotalPages());
		assertEquals(true,result.hasNextPage());
		assertEquals(false,result.isLastPage());
		assertEquals(2,result.getNextPageNo());
		assertEquals(false,result.hasPrePage());
		assertEquals(true,result.isFirstPage());
		assertEquals(1,result.getPrePageNo());

		
	}
	
	@Test
	public void test1() {
		PageParam param=PageParam.getInstance(10, 10);
		
		PageResult result=new PageResult(param);
		result.setTotal(15);
		
		assertEquals(10, result.getStart());
		assertEquals(10, result.getLimit());
		assertEquals(2, result.getPageNo());	
		assertEquals(15, result.getTotal());
		assertEquals(0,result.getResultSize());
		assertEquals(2,result.getTotalPages());
		assertEquals(false,result.hasNextPage());
		assertEquals(true,result.isLastPage());
		assertEquals(2,result.getNextPageNo());
		assertEquals(true,result.hasPrePage());
		assertEquals(false,result.isFirstPage());
		assertEquals(1,result.getPrePageNo());

		
	}

}
