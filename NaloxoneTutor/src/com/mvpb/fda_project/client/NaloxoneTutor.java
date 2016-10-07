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
import com.google.gwt.media.client.Audio;
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
public class NaloxoneTutor implements EntryPoint {
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
	
	private static NaloxoneTutorUI ui = new NaloxoneTutorUI();
	
	private static FlowPanel nav = new FlowPanel();
	
	private static int selected = 0;
	
	private static Audio dictation;
	
	public static void next() {
		++selected;
		if (selected >= txt.length) selected = txt.length-1;
		select(selected);
	}
	
	public static void prev() {
		--selected;
		if (selected < 0) selected = 0;
		select(selected);
	}
	
	public static void toggleDictation() {
		if (dictation != null) {
			dictation.pause();
			dictation = null;
			NaloxoneTutorUI.audio.setHTML("&#x1F507;");
		} else {
			dictation = Audio.createIfSupported();
			select(selected);
			NaloxoneTutorUI.audio.setHTML("&#x1F50A;");
		}
	}
	
	private static void select(int idx) {
		Widget wid;
		wid = nav.getWidget(0);
		wid.addStyleDependentName("first");
		for (int i=0; i<txt.length; ++i)
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
		w.setStyleName("gwt-mainItem");
		ui.setMain(w);
		selected = idx;
		// Play audio
		if (dictation != null) {
			dictation.setSrc("audio/0" + (idx+1) + ".mp3");
			dictation.play();
		}
	}

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Window.enableScrolling(false);
		RootLayoutPanel rp = RootLayoutPanel.get();
		rp.add(ui);
		
		dictation = Audio.createIfSupported();

		for (int i=0; i<txt.length; ++i) {
			NavItem b = new NavItem(i);
			b.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					int idx = ((NavItem)event.getSource()).getIdx();
					NaloxoneTutor.select(idx);
				}
			});
			nav.add(b);
		}
		ui.setNav(nav);
	    select(0);
	}
}
