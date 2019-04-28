package com.devcon.springboot.vaadin;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hack")
public class HelloComponent extends VerticalLayout{

	private TextField name = new TextField("Name");
	private TextField email = new TextField("Email");
	private Company company = new Company();
	
	public HelloComponent() {
		
		Div message = new Div();
		Button click = new Button("Add User");
		click.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY);
		
		click.addClickListener(event->{
			TextField nameField = new TextField();
			nameField.setLabel("First Name");
			nameField.setPlaceholder("First Name");
			
			TextField lastNameField = new TextField();
			lastNameField.setLabel("Last Name");
			lastNameField.setPlaceholder("Last Name");
			
			TextField positionField = new TextField();
			positionField.setLabel("Position");
			positionField.setPlaceholder("Position");

			
			message.add(nameField);
			message.add(lastNameField);
			message.add(positionField);
			
			Button save = new Button("save");
			
			
			message.add(save);
			
			save.addClickListener(event1->{
				Employee employee = new Employee(nameField.getValue(), lastNameField.getValue(), positionField.getValue());
			
				RestTemplate restTemplate = new RestTemplate();
				
				restTemplate.postForObject(
						"https://xxx.appspot.com/user/create",
						  employee,
						  ResponseEntity.class);
			});

			
		});	
		
		add(click, message);
//		
//		Binder<Employee> binder = new BeanValidationBinder<>(Employee.class);
//		binder.bindInstanceFields(this);
//		
//		Button save = new Button("save");
//		save.addClickListener(event->{
//			binder.validate();
//		});
//		
//		add(name, email, save);		
		
		Grid<Employee> grid = new Grid<>(Employee.class);
		grid.setPageSize(1);
		grid.setItems(getList());
		grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
					
		add(grid);
		
		
	}
	
//	public List<Employee> getList(){
//		List<Company> companyList = new ArrayList<>();
//		companyList.add(new Company("dj", "dj@gmail.com"));
//		companyList.add(new Company("niko", "niko@gmail.com"));
		
//		List<Employee> response = restTemplate.getForObject(
//				  "https://xxx.appspot.com/user/lists",
//				  Employee.class);
//				List<Employee> employees = response.getEmployees();
		
//		return employees;
//	}
	
	public List<Employee> getList() {
	
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<List<Employee>> response = restTemplate.exchange(
	  "https://xxx.appspot.com/user/lists",
	  HttpMethod.GET,
	  null,
	  new ParameterizedTypeReference<List<Employee>>(){});
	
	return response.getBody();
	}
}
