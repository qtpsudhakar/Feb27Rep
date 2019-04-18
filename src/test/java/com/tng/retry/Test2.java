package com.tng.retry;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test2{

	  @Test()
	  public void t1() {
		  System.out.println("this is t1 test method");
	  }

	  @Test()
	  public void t2() {
		  Assert.assertEquals(false, true);
		  System.out.println("this is t2 test method");
	  }

	  @Test()
	  public void t3() {
		  System.out.println("this is t3 test method");
	  }
}
