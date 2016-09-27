package com.mvpb.fda_project.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

public class NavItem extends Label {
	private int idx;
	
	public NavItem(int v) {
		super("Step " + (v + 1));
		idx = v;
	}
	
	public int getIdx() {
		return idx;
	}
}
