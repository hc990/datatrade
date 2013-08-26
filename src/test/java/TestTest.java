package test.java;

import main.java.Hello;

import org.junit.Test;

public class TestTest {  
	
  @Test
  public void testHello(){
	  Hello hello = new Hello();
	  hello.hello("test");
	  
  }
	
}
