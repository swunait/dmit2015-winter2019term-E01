package northwind.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import lombok.Getter;
import lombok.Setter;
import northwind.entity.Shipper;
import northwind.service.NorthwindService;

@Named
@ViewScoped
public class ShipperCRUDController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NorthwindService northwindService;
	
	private List<Shipper> shippers;	// +getter
	
	// The current Shipper to create, edit, or update
	@Getter @Setter private Shipper currentShipper = new Shipper();	// +getter +setter
	
	@PostConstruct
	void init() {
		try {
			shippers = northwindService.findAllShipper();
		} catch (Exception e) {
			Messages.addGlobalError("Error retreiving from Shippers table");
			Messages.addGlobalError("Exception: ", e.getMessage());
		}
	}

	public String create() {
		String outcome = null;
		try {
			northwindService.createNewShipper(currentShipper);
			
			currentShipper = new Shipper();
			Messages.addFlashGlobalInfo("Create was successful");
			outcome = "list?faces-redirect=true";
		} catch(Exception e) {
			Messages.addGlobalError("Create was not successful");
			Messages.addGlobalError("Exception: ", e.getMessage());
		}
		return outcome;
	}
	
	public void delete(Shipper existingShipper) {
		try {
			northwindService.removeShipper(existingShipper);
			shippers.remove(existingShipper);
			Messages.addGlobalInfo("Delete was successful");
		} catch(Exception e) {
			Messages.addGlobalError("Delete was not succesful");
		}
	}
	
	public List<Shipper> getShippers() {
		return shippers;
	}
	
	
	

}
