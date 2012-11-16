package com.example.project.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public interface ProjServiceAsync {

	void dziel(int l1, int l2, AsyncCallback<Double> callback);
	void mnoz(int l1, int l2, AsyncCallback<Double> callback);
	void dodaj(int l1, int l2, AsyncCallback<Integer> callback);
	void odejmij(int l1, int l2, AsyncCallback<Integer> callback);
	void quadEx(int listGridRecords, int parseInt2,  int parseInt3, AsyncCallback<String> asyncCallback);
	void obliczBMI(float f, float g, AsyncCallback<String> asyncCallback);
}
