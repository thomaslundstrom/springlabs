package xmlconfiguredbeans.impl;

import xmlconfiguredbeans.FactoryCreatedBeanFive;

public class BeanFiveFactory {

	private FactoryCreatedBeanFive instance;
	
	public synchronized FactoryCreatedBeanFive getBeanFiveInstance() {
		if(instance == null)
			instance = new FactoryCreatedBeanFiveImpl(5);
		
		return instance;
	}
	
}
