package com.syskan.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Table {

	private List<TreeMap<String, String>> rows = new ArrayList<TreeMap<String, String>>();

	public List<TreeMap<String, String>> getRows() {
		return rows;
	}

	public void setRows(List<TreeMap<String, String>> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Table [rows=" + rows + "]";
	}

}
