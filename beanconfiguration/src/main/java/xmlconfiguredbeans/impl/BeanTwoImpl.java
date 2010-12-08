package xmlconfiguredbeans.impl;

import org.apache.commons.logging.Log;

import xmlconfiguredbeans.BeanThree;
import xmlconfiguredbeans.BeanTwo;

public class BeanTwoImpl implements BeanTwo {

	private int number;
	private String property;
	private BeanThree beanThree;
	private final Log logger;
	

	public BeanTwoImpl(Log logger) {
		this.logger = logger;
	}
	
	public void setNumber(int value) {
		this.number = value;
	}

	@Override
	public int getNumber() {
		logger.info("returning number " + this.number);
		return this.number;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Override
	public String getProperty() {
		return property;
	}

	public void setBeanThree(BeanThree value) {
		this.beanThree = value;
	}

	@Override
	public BeanThree getBeanThree() {
		return this.beanThree;
	}

}
