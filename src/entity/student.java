package entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@ManagedBean
@SessionScoped
@Entity
@Table(name="student")
public class student {

	@Id	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	
	public student() {
		
	}


	public student( String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String  save()
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(student.class).buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		try{
			//start a transaction 
			session.beginTransaction();
			
			//save the student object		
			session.save(this);
			
			//commit transaction
			session.getTransaction().commit();
						
		}finally{
			factory.close();
		}	
	    return "success.xhtml";
	}
	
	
}




