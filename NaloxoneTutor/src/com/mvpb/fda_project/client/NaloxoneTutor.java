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
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
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
	
	private NaloxoneTutorUI ui = new NaloxoneTutorUI();
	
	private FlowPanel nav = new FlowPanel();
	
	private void select(int idx) {
		Widget wid;
		for (int i=0; i<8; ++i)
		{
			wid = nav.getWidget(i);
			wid.removeStyleDependentName("done");
			wid.removeStyleDependentName("active");
			wid.removeStyleDependentName("todo");
			if (i < idx) {
				wid.addStyleDependentName("done");
			}
			
			if (i==idx) {
				wid.addStyleDependentName("active");
				ui.ensureVisible(wid);
			}
			if (i>idx) {
				wid.addStyleDependentName("todo");
			}
		}

		// Update main window
		HTML w = new HTML(txt[idx]);
		w.setStyleName("mainItem");
		ui.setMain(w);
	}

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Window.enableScrolling(false);
		RootLayoutPanel rp = RootLayoutPanel.get();
		rp.add(ui);

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
