package dogclinic.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Owner")
@XmlType(propOrder = { "phone", "email", "dogs" })
public class Owner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2047161112755251781L;
	
	@XmlTransient
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlElement
	private Integer phone;
	@XmlElement
	private String email;
	@XmlElement(name = "Dog")
	@XmlElementWrapper(name = "Dogs")
	private List<Dog> dogs;
	
	public Owner() {
		super();
		dogs = new ArrayList<Dog>();
	}
	
	
	public Owner(String name, Integer phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		dogs = new ArrayList<Dog>();
	}


	public Owner(Integer id, String name, Integer phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		// ALWAYS INITIALIZE LISTS
		this.dogs = new ArrayList<Dog>();
	}


	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", dogs=" + dogs + "]";
	}


	public List<Dog> getDogs() {
		return dogs;
	}
	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}
	
	public void addDog(Dog dog) {
		if (!dogs.contains(dog)) {
			dogs.add(dog);
		}
	}
	
	public void removeDog(Dog dog) {
		if (dogs.contains(dog)) {
			dogs.remove(dog);
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
