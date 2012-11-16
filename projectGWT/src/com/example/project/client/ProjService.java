package com.example.project.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("greet")
public interface ProjService extends RemoteService {
	
	Double dziel(int l1, int l2);
	Double mnoz(int l1, int l2);
	Integer dodaj(int l1, int l2);
	Integer odejmij(int l1, int l2);
	String quadEx(int l1, int l2, int l3);
	String obliczBMI (float l1, float l2);
}
