package northwind.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class CategorySalesRevenue {

	private String categoryName;
	private Double categorySalesTotal;
	
}
