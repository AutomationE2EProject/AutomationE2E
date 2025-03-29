package com.uo.pojo;

import java.util.HashMap;
import java.util.Map;

public class Config {
	private Map<String, Environment> environments = new HashMap<String, Environment>();

	public Map<String, Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Map<String, Environment> environments) {
		this.environments = environments;
	}
}
