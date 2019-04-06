package northwind.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJBAccessException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import lombok.Getter;
import lombok.Setter;
import northwind.report.CategorySalesRevenue;
import northwind.service.NorthwindService;

@Named
@ViewScoped
public class CategorySalesRevenueReportController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NorthwindService northwindService;
	
	@Getter private List<Integer> salesYears;
	@Getter @Setter private Integer selectedSalesYear;
	
	@Getter private List<CategorySalesRevenue> categorySalesRevenue;
	
	@PostConstruct
	void init() {
		try {
			salesYears = northwindService.findYearsWithOrders();
			categorySalesRevenue = northwindService.findCategorySalesRevenues();
		} catch(EJBAccessException e) {
			Messages.addGlobalWarn("You do not have permission this resource.");
		} catch(Exception e) {
			Messages.addGlobalError("Error retrieving category sales report");
		}
	}
	
	public void generateReport() {
		try {
			if (selectedSalesYear == null) {
				categorySalesRevenue = northwindService.findCategorySalesRevenues();
			} else {
				categorySalesRevenue = northwindService.findCategorySalesRevenuesByYear(selectedSalesYear);
			}
		} catch(EJBAccessException e) {
			Messages.addGlobalWarn("You do not have permission this resource.");
		} catch(Exception e) {
			Messages.addGlobalError("Error retrieving category sales report");
		}
	}

}
