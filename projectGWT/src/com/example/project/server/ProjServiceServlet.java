package com.example.project.server;

import java.io.Console;

import com.example.project.client.ProjService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ProjServiceServlet extends RemoteServiceServlet implements
ProjService {

	private static final long serialVersionUID = 1L;

	@Override
	public Double dziel(int l1, int l2) {
		return l1 * 1.0 / l2;
	}
	
	@Override
	public Double mnoz(int l1, int l2) {
		return l1 * l2 * 1.0;
	}

	@Override
	public Integer dodaj(int l1, int l2) {
		return l1 + l2;
	}

	@Override
	public Integer odejmij(int l1, int l2) {
		return l1 - l2;
	}
	private static final int MAX_BASE = 36;
	private static final String pattern = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	
	@Override
	public String obliczBMI(float height, float weight) {
		String result = "";
		double bmi = 0.0;
		
		double heightM  = 0.0;
		heightM = (double)height / 100.0;
		
		
		bmi = weight / (heightM * heightM);
		
		if ( bmi < 18.5){
			result = "Posiadasz niedowagê!  Twoje BMI to: " + bmi;
		}
		else if (bmi >= 18.5 && bmi < 25.0){
			result = "Posiadasz odpowiedni¹ wagê.  Twoje BMI to: " + bmi;
		}
		
		else if (bmi >= 25.0){
			result = 	"Posiadasz nadwagê! Twoje BMI to: " + bmi;
		}

		return result;
	}
	
	@Override
	public String quadEx(int a, int b, int c) {
		String wynik;
		double delta;
		delta = (b*b) - (4*a*c);
		
		if ( delta > 0){
			wynik = "x1 = "+((-b -Math.sqrt(delta))/2*a) +", x2 = "+((-b +Math.sqrt(delta))/2*a);
			
		}else if(delta == 0){
			wynik = "x1 = "+(-b/2*a);
			
		}
		else{ 
			wynik = "Brak rozwi¹zañ rzeczywistych";
		}
		return wynik;
	}

}
