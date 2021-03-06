package xmlconfiguredbeans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xmlconfiguredbeans.BeanOne;
import xmlconfiguredbeans.BeanThree;
import xmlconfiguredbeans.BeanTwo;

public class XmlConfigurationTests {
	
	private ApplicationContext ctx;

	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("/application-context.xml");
	}
	
	@Test
	public void appContextShouldBeInititated() {
		assertNotNull(ctx);
	}
	
	@Test
	public void canGetBeanOneWithDeps() {
		BeanOne beanOne = ctx.getBean(BeanOne.class);
		
		assertNotNull(beanOne);
		assertNotNull(beanOne.getBeanTwo());
	}
	
	@Test
	public void canGetProperty() {
		BeanTwo two = ctx.getBean(BeanTwo.class);
		assertEquals(3, two.getNumber());
	}

	
	@Test
	public void canGetPropertyWithP() {
		BeanTwo two = ctx.getBean(BeanTwo.class);
		assertEquals("property", two.getProperty());
	}
	
	@Test
	public void canGetRefWithP() {
		BeanTwo two = ctx.getBean(BeanTwo.class);
		BeanThree three = two.getBeanThree();
		
		assertNotNull(three);
	}
	
	@Test
	public void canGetSingletonBean() {
		SingletonBeanFour four = ctx.getBean(SingletonBeanFour.class);
		assertNotNull(four);
	}
	
	@Test
	public void canGetFactoryCreatedBean() {
		FactoryCreatedBeanFive five = ctx.getBean(FactoryCreatedBeanFive.class);
		assertNotNull(five);
	}
	
	@Test
	public void canGetList() {
		BeanThree three = (BeanThree) ctx.getBean(BeanThree.class);
		
		assertEquals("first", three.getList().get(0));
	}
	
	@Test
	public void canGetMap() {
		BeanThree three = (BeanThree) ctx.getBean(BeanThree.class);
		
		assertEquals("firstinmap", three.getMap().get("firstkey"));
	}
	
	@Test
	public void canGetProperties() {
		BeanThree three = (BeanThree) ctx.getBean(BeanThree.class);
		
		assertEquals("1", three.getProperties().get("one"));
		assertEquals("two", three.getProperties().get("two"));
		assertEquals("numberthree", three.getProperties().get("three"));
	}
}
