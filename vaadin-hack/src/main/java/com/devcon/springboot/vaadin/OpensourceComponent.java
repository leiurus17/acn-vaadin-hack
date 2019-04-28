package com.devcon.springboot.vaadin;

import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("component")
public class OpensourceComponent extends VerticalLayout {
	
	public OpensourceComponent() {
		/*
		DatePicker datePicker = new DatePicker("I'm a date picker");
		datePicker.addValueChangeListener(event->{
			Notification.show(event.getValue().toString(), 5000, Position.MIDDLE);
		});
		
		MemoryBuffer memoryBuffer = new MemoryBuffer();
		Upload upload = new Upload(memoryBuffer);
		upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");
		upload.setMaxFiles(3);
		upload.addSucceededListener(event->{
			memoryBuffer.getInputStream()
			Notification.show("File uploaded successfully");
		});
		
		Button greet = new Button("Button with Icon", VaadinIcon.PLUG.create());
		*/
		
		LoginForm login = new LoginForm();
		login.addLoginListener(event->{
			
			if(authenticate(event)) {
				Notification.show("Login successfully");
			}
			else {
				login.setError(true);
			}
		});
		
		add(login);
	}
	
	public boolean authenticate(LoginEvent e) {
		boolean isAuthenticated = false;
		if(e.getUsername().equals("user") && e.getPassword().equals("secret")) {
			isAuthenticated = true;
		}
		
		return isAuthenticated;
	}

}
