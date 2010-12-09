package xmlconfiguredbeans.impl;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import xmlconfiguredbeans.BeanThree;

public class BeanThreeImpl implements BeanThree {

	private final List<String> list;
	private final Map<String, String> map;
	private final Properties props;

	public BeanThreeImpl(List<String> list, Map<String, String> map, Properties props) {
		this.list = list;
		this.map = map;
		this.props = props;
	}

	@Override
	public List<String> getList() {
		return list;
	}
	
	@Override
	public Map<String, String> getMap() {
		return map;
	}
	
	@Override
	public Properties getProperties() {
		return props;
	}
}
