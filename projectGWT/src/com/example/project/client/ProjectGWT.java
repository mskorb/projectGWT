	package com.example.project.client;

import java.awt.TextField;


import com.example.project.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.widgets.Slider;  
import com.smartgwt.client.widgets.events.DrawEvent;  
import com.smartgwt.client.widgets.events.DrawHandler;  
import com.smartgwt.client.widgets.events.ValueChangedEvent;  
import com.smartgwt.client.widgets.events.ValueChangedHandler;  
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectOtherItem;
   
   
  
import com.google.gwt.core.client.EntryPoint; 


public class ProjectGWT implements EntryPoint {

	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private final ProjServiceAsync projService = GWT
			.create(ProjService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		TabLayoutPanel tabPanel = new TabLayoutPanel(2.5, Unit.EM);
		FlexTable flexCalc = new FlexTable();

		DecoratorPanel roundsCorner = new DecoratorPanel();
		HorizontalPanel hp = new HorizontalPanel();
		Button plusButton = new Button("+");
		Button minusButton = new Button("-");
		Button devideButton = new Button("/");
		Button multiplyButton = new Button("*");
		hp.add(plusButton);
		hp.add(minusButton);
		hp.add(devideButton);
		hp.add(multiplyButton);
		final TextBox l1 = new TextBox();
		final TextBox l2 = new TextBox();
		final Label wynik = new Label();
		flexCalc.setHTML(0,0,"x:");
		flexCalc.setWidget(0,1, l1);
		
		flexCalc.setHTML(1,0, " ");
		flexCalc.setWidget(1, 1, hp);
		flexCalc.setHTML(2,0, "y:");
		flexCalc.setWidget(2,1,l2);
		
		flexCalc.setHTML(3,0, "Wynik");
		flexCalc.setWidget(3,1, wynik);
		roundsCorner.add(flexCalc);
		tabPanel.add(roundsCorner, new HTML("Kalkulator"));
		// <=== end kalkulator ===>
		
		
		// <==== przeliczanie BMI ======>
		DecoratorPanel decBMI = new DecoratorPanel();
		
		final Label wynikBMI = new Label();
		
		
		Button obliczBMI = new Button("Oblicz BMI");
		VerticalPanel vPanel = new VerticalPanel();
	    vPanel.setSpacing(5);
	    
	    final Slider hSlider = new Slider("wzrost");
	 	hSlider.setVertical(false);
        hSlider.setMinValue(100);  
        hSlider.setMaxValue(220);  
        hSlider.setNumValues(120);  
   

        final Slider wSlider = new Slider("waga");
	 	wSlider.setVertical(false);
        wSlider.setMinValue(10);  
        wSlider.setMaxValue(150);  
        wSlider.setNumValues(140); 
        
	    vPanel.add(hSlider);
	    vPanel.add(wSlider); 
	    
	    
	    vPanel.add(wynikBMI);
	    
	    vPanel.add(obliczBMI);
	    
	    decBMI.setWidget(vPanel);
		tabPanel.add(decBMI, new HTML("Oblicz BMI"));
	
		
		/*
		 * canvas.addChild("Wynik:");
		 
		
		flex_bmi.setHTML(2, 0, "Wynik:");
		flex_bmi.setWidget(2, 1, wynikBMI);
		flex_bmi.setWidget(3, 0, obliczBMI);
		 final Slider hSlider = new Slider("wzrost");
		 	hSlider.setVertical(false);
	        hSlider.setMinValue(100);  
	        hSlider.setMaxValue(220);  
	        hSlider.setNumValues(100);  
	    flex_bmi.setWidget(4, 0, hSlider);  
	    
		decBMI.setWidget(canvas);
			
        
		tabPanel.add(decBMI, new HTML("Oblicz BMI"));
		*/
		// Koniec BMI
		
		// <==== przeliczanie równanie kwadratowe ======>
		DecoratorPanel decQuad = new DecoratorPanel();
		FlexTable flexQuad = new FlexTable();
		final TextBox a = new TextBox();
		final TextBox b = new TextBox();
		final TextBox c = new TextBox();
		
		final Label wynikQuad = new Label();
		Button obliczQuad = new Button("Oblicz");
		final DynamicForm form = new DynamicForm();  
        form.setWidth(300);  
  
        final SelectOtherItem selectOtherItem = new SelectOtherItem();  
        selectOtherItem.setOtherTitle("Other..");  
        selectOtherItem.setOtherValue("OtherVal");  
        selectOtherItem.setTitle("Add on the fly");
        selectOtherItem.setValueMap("2", "4", "6", "8");  
        form.setFields(selectOtherItem);  
  
        	
		flexQuad.setHTML(0, 0, "Podaj a:");
		flexQuad.setWidget(0, 1, form);
		flexQuad.setHTML(1, 0, "Podaj b");
		flexQuad.setWidget(1, 1, b);
		flexQuad.setHTML(2, 0, "Podaj c");
		flexQuad.setWidget(2, 1, c);
		flexQuad.setHTML(3, 0, "Wynik:");
		flexQuad.setWidget(3, 1, wynikQuad);
		flexQuad.setWidget(4, 0, obliczQuad);
		decQuad.setWidget(flexQuad);
		tabPanel.add(decQuad, new HTML("Równanie kwadratowe"));
		// Koniec równania kwadratowego	
		
		

		RootLayoutPanel.get().add(tabPanel);
		
	 	
		
obliczBMI.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				projService.obliczBMI((hSlider.getValue()), (wSlider.getValue()), new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						wynikBMI.setText(SERVER_ERROR);
						
					}
					@Override
					public void onSuccess(String result) {
						wynikBMI.setText(" " + result);
						
					}
				});
				
			}
		});



obliczQuad.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		projService.quadEx(Integer.parseInt((String) selectOtherItem.getValue()), Integer.parseInt(b.getText()), Integer.parseInt(c.getText()), new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				wynikQuad.setText(SERVER_ERROR);
				
			}
			@Override
			public void onSuccess(String result) {
				wynikQuad.setText(" " + result);
				
			}
		});
		
	}
});
	
		plusButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				projService.dodaj(Integer.parseInt(l1.getText()), Integer.parseInt(l2.getText()), new AsyncCallback<Integer>() {

					@Override
					public void onFailure(Throwable caught) {
						wynik.setText(SERVER_ERROR);
						
					}

					@Override
					public void onSuccess(Integer result) {
						wynik.setText("" + result);
						
					}
				});
				
			}
		});
		minusButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				projService.odejmij(Integer.parseInt(l1.getText()), Integer.parseInt(l2.getText()), new AsyncCallback<Integer>() {

					@Override
					public void onFailure(Throwable caught) {
						wynik.setText(SERVER_ERROR);
						
					}

					@Override
					public void onSuccess(Integer result) {
						wynik.setText("" + result);
						
					}
				});
				
			}
		});
		devideButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				projService.dziel(Integer.parseInt(l1.getText()), Integer.parseInt(l2.getText()), new AsyncCallback<Double>() {

					@Override
					public void onFailure(Throwable caught) {
						wynik.setText(SERVER_ERROR);
						
					}

					@Override
					public void onSuccess(Double result) {
						wynik.setText("" + result);
						
					}
				});
				
			}
		});
		multiplyButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				projService.mnoz(Integer.parseInt(l1.getText()), Integer.parseInt(l2.getText()), new AsyncCallback<Double>() {

					@Override
					public void onFailure(Throwable caught) {
						wynik.setText(SERVER_ERROR);
						
					}

					@Override
					public void onSuccess(Double result) {
						wynik.setText("" + result);
						
					}
				});
				
			}
		});
	}
}
