package com.mvpb.fda_project.client;

import com.mvpb.fda_project.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.impl.WindowImplIE.Resources;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class NaloxoneTutor implements EntryPoint, ClickHandler {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	
	private static String[] txt = { 
			Rsrc.INSTANCE.s01().getText(),
			Rsrc.INSTANCE.s02().getText(),
			Rsrc.INSTANCE.s03().getText(),
			Rsrc.INSTANCE.s04().getText(),
			Rsrc.INSTANCE.s05().getText(),
			Rsrc.INSTANCE.s06().getText(),
			Rsrc.INSTANCE.s07().getText(),
			Rsrc.INSTANCE.s08().getText()
		};
	
	private void sizeWidget(Widget w) {
		int height = Window.getClientHeight();
		int width = Window.getClientWidth();
	    final String swidth = new Integer((int)((float)width-80)).toString() + "px";
	    final String sheight = new Integer((int)((float)height-80)).toString() + "px";
	    w.setSize(swidth, sheight);
	}
	
	private NaloxoneTutorUI ui = new NaloxoneTutorUI();
	
	private VerticalPanel nav = new VerticalPanel();
	
	private void select(int idx) {
		// Change state of navigation panel
		for (int i=0; i < idx; ++i) {
			nav.getWidget(i).setStyleName("gwt-NavItem-done");
		}
		
		nav.getWidget(idx).setStyleName("gwt-NavItem-active");
		
		for (int i=idx+1; i < 8; ++i) {
			nav.getWidget(i).setStyleName("gwt-NavItem-todo");
		}
		
		// Update main window
		HTML w = new HTML(txt[idx]);
		ui.setMain(w);
	}

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		nav.setStyleName("gwt-navContainer");
		RootPanel.get("main").add(ui);
	    sizeWidget(ui);
		
		for (int i=0; i<8; ++i) {
			NavItem b = new NavItem(i);
			b.addClickHandler(this);
			nav.add(b);
		}
		ui.setNav(nav);
	    select(0);
	}
	public void onClick(ClickEvent event) {
		NavItem currentItem = (NavItem)(event.getSource());
		select(currentItem.getIdx());
	}
}
