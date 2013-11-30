package de.effectivetrainings;

import de.effectivetrainings.product.Product;
import de.effectivetrainings.product.ProductsModel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import javax.inject.Inject;

public class HomePage extends WebPage {

    @Inject
    private ProductsModel productsModel;

	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
        add(new ListView<Product>("products", productsModel) {
            @Override
            protected void populateItem(ListItem<Product> item) {
                item.add(new Label("productName", new PropertyModel(item.getModel(), "name")));
                item.add(new Label("productPrize", new PropertyModel(item.getModel(), "prize")));
            }
        });
    }
}
