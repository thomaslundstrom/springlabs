package xmlconfiguredbeans.impl;

import xmlconfiguredbeans.BeanOne;
import xmlconfiguredbeans.BeanTwo;

public class BeanOneImpl implements BeanOne {

	private final BeanTwo beanTwo;

	public BeanOneImpl(BeanTwo beanTwo) {
		this.beanTwo = beanTwo;
	}
	
	public BeanTwo getBeanTwo() {
		return beanTwo;
	}
	
}
