package xmlconfiguredbeans.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import xmlconfiguredbeans.BeanThree;
import xmlconfiguredbeans.BeanTwo;

public class BeanTwoImpl implements BeanTwo, InitializingBean, DisposableBean {

	private int number;
	private String property;
	private BeanThree beanThree;
	private Log logger;
	

	public BeanTwoImpl() {
	}
	
	public void setNumber(int value) {
		this.number = value;
	}

	@Override
	public int getNumber() {
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

	@Override
	public void afterPropertiesSet() throws Exception {
		writeLog("inside InitializingBean.afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		writeLog("inside DisposableBean.destroy()");
	}

	private void writeLog(String message) {
		if(logger != null)
			logger.info(message);
	}

	public Log getLogger() {
		return logger;
	}
	
	public void setLogger(Log value) {
		this.logger = value;
	}

	public void destroyMethodFromXml() {
		writeLog("inside xml destroy-method");
	}
	
	public void initMethodFromXml() {
		writeLog("inside xml init-method");
	}
	
	@PostConstruct
	public void postConstruct() {
		writeLog("inside @PostConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		writeLog("inside @PreDestroy");
	}

}
