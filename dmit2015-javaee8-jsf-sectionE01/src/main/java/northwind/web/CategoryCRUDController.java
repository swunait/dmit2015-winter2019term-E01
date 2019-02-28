package northwind.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import northwind.entity.Category;
import northwind.service.NorthwindService;

@Named
@ViewScoped
public class CategoryCRUDController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private NorthwindService northwindService;
	
	private List<Category> categorys;			// +getter
	
	@Produces
	@Named
	private Category newCategory;
	
	@PostConstruct
	void init() {
		categorys = northwindService.findAllCategory();
		newCategory = new Category();
	}
	
	public void createNewCategory() {
		try {
			northwindService.createCategory(newCategory);
			init();
			Messages.addGlobalInfo("Create successful");
		} catch(Exception e) {
			Messages.addGlobalError("Add unsucessful");
			Messages.addGlobalError("Exception: " + e.getMessage());
		}
	}

	@Produces
	@Named
	public List<Category> getCategorys() {
		return categorys;
	}
	
}