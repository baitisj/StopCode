package com.mvpb.fda_project.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface Rsrc extends ClientBundle {
	public static final Rsrc INSTANCE = GWT.create(Rsrc.class);

	@Source("text/01.html") TextResource s01();
	@Source("text/02.html") TextResource s02();
	@Source("text/03.html") TextResource s03();
	@Source("text/04.html") TextResource s04();
	@Source("text/05.html") TextResource s05();
	@Source("text/06.html") TextResource s06();
	@Source("text/07.html") TextResource s07();
	@Source("text/08.html") TextResource s08();
		
}
