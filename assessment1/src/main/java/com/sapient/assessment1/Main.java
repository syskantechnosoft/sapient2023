package com.sapient.assessment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class UniqueList {
	private HashSet masterSet = new HashSet();
	private ArrayList innerList;
	private Object[] returnable;

	public UniqueList() {
		innerList = new ArrayList();
	}

	public UniqueList(int size) {
		innerList = new ArrayList(size);
	}

	public void add(Object thing) {
		if (!masterSet.contains(thing)) {
			masterSet.add(thing);
			innerList.add(thing);
		}
	}

	public List getList() {
		return innerList;
	}

	public Object get(int index) {
		return innerList.get(index);
	}

	public Object[] toObjectArray() {
		int size = innerList.size();
		returnable = new Object[size];
		for (int i = 0; i < size; i++) {
			returnable[i] = innerList.get(i);
		}
		return returnable;
	}
}

public class Main {
	public static void main(String[] args) {
		UniqueList ul = new UniqueList();
		ul.add("Test");
		ul.add("Test");
		ul.add("Not a copy");
		ul.add("Test");
		System.out.println(ul.getList());
		Object[] content = ul.toObjectArray();
		System.out.println(Arrays.toString(content));
	}
}
