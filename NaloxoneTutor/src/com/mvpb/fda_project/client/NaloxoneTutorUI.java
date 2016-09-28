package com.mvpb.fda_project.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class NaloxoneTutorUI extends Composite implements HasText {

	private static NaloxoneTutorUIUiBinder uiBinder = GWT.create(NaloxoneTutorUIUiBinder.class);

	interface NaloxoneTutorUIUiBinder extends UiBinder<Widget, NaloxoneTutorUI> {
	}

	public NaloxoneTutorUI() {
		initWidget(uiBinder.createAndBindUi(this));
		prev.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				NaloxoneTutor.prev();
			}
		});
		
		next.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				NaloxoneTutor.next();
			}
		});
	}

	@UiField
	ScrollPanel M;
	
	@UiField
	ScrollPanel W;
	
	@UiField
	FlowPanel S;
	
	@UiField
	Button prev;
	
	@UiField
	Button next;
	
	public void setMain(Widget w) {
		M.clear();
		M.add(w);
	}
	
	public void setNav(Widget w) {
		W.clear();
		W.add(w);
	}
	
	public void ensureVisible(Widget w) {
		W.ensureVisible(w);
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
