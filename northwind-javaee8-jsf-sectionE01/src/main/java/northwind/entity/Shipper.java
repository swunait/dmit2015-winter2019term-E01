package northwind.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


/**
 * The persistent class for the Shippers database table.
 * 
 */
@Entity
@Table(name="Shippers")
@NamedQuery(name="Shipper.findAll", query="SELECT s FROM Shipper s")
public class Shipper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ShipperID")
	private int shipperID;

	@NotBlank(message="Company Name value is required")
	@Size(min=3,max=40, message="Company Name value must contain 3 to 40 characters")
	@Column(name="CompanyName")
	private String companyName;

	@Column(name="Phone")
	@Size(max=14, message="Phone value be less or equal to 14 characters")
	private String phone;

	public Shipper() {
	}

	public int getShipperID() {
		return this.shipperID;
	}

	public void setShipperID(int shipperID) {
		this.shipperID = shipperID;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}