package com.mvpb.fda_project.client;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.ui.Label;

public class NavItem extends Label {
	private int idx;
	
	public NavItem(int v) {
		super("Step " + (v + 1));
		idx = v;
		this.getElement().getStyle().setDisplay(Display.BLOCK);
	}
	
	public int getIdx() {
		return idx;
	}
}
