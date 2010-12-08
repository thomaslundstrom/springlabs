package xmlconfiguredbeans.impl;

import xmlconfiguredbeans.SingletonBeanFour;

public class SingletonBeanFourImpl implements SingletonBeanFour {

	private static SingletonBeanFourImpl instance;
	
	public synchronized static SingletonBeanFourImpl getInstance() {
		if(instance == null)
			instance = new SingletonBeanFourImpl();
		
		return instance;
	}
}
