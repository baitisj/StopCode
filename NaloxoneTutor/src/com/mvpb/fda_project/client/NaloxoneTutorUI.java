package com.mvpb.fda_project.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class NaloxoneTutorUI extends Composite implements HasText {

	private static NaloxoneTutorUIUiBinder uiBinder = GWT.create(NaloxoneTutorUIUiBinder.class);

	interface NaloxoneTutorUIUiBinder extends UiBinder<Widget, NaloxoneTutorUI> {
	}

	public NaloxoneTutorUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	HTMLPanel M;
	
	@UiField
	HTMLPanel W;
	
	public void setMain(Widget w) {
		M.clear();
		M.add(w);
	}
	
	public void setNav(Widget w) {
		W.clear();
		W.add(w);
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

}
