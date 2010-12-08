package xmlconfiguredbeans.impl;

import java.util.List;
import java.util.Map;

import xmlconfiguredbeans.BeanThree;

public class BeanThreeImpl implements BeanThree {

	private final List<String> list;
	private final Map<String, String> map;

	public BeanThreeImpl(List<String> list, Map<String, String> map) {
		this.list = list;
		this.map = map;
	}

	@Override
	public List<String> getList() {
		return list;
	}
	
	@Override
	public Map<String, String> getMap() {
		return map;
	}
}
