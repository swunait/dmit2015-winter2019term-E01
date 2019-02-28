package northwind.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the Products database table.
 * 
 */
@Entity
@Table(name="Products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductID")
	private int productID;

	@Column(name="Discontinued")
	private byte discontinued;

	@Column(name="ProductName")
	private String productName;

	@Column(name="QuantityPerUnit")
	private String quantityPerUnit;

	@Column(name="ReorderLevel")
	private short reorderLevel;

	@Column(name="SupplierID")
	private int supplierID;

	@Column(name="UnitPrice")
	private BigDecimal unitPrice;

	@Column(name="UnitsInStock")
	private short unitsInStock;

	@Column(name="UnitsOnOrder")
	private short unitsOnOrder;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CategoryID")
	private Category category;

	public Product() {
	}

	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public byte getDiscontinued() {
		return this.discontinued;
	}

	public void setDiscontinued(byte discontinued) {
		this.discontinued = discontinued;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantityPerUnit() {
		return this.quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public short getReorderLevel() {
		return this.reorderLevel;
	}

	public void setReorderLevel(short reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public int getSupplierID() {
		return this.supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public short getUnitsInStock() {
		return this.unitsInStock;
	}

	public void setUnitsInStock(short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public short getUnitsOnOrder() {
		return this.unitsOnOrder;
	}

	public void setUnitsOnOrder(short unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}