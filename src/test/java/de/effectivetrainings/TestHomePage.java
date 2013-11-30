package de.effectivetrainings;

import de.effectivetrainings.product.ProductsModel;
import org.apache.wicket.cdi.AbstractCdiContainer;
import org.apache.wicket.cdi.CdiConfiguration;
import org.apache.wicket.cdi.ConversationExpiryChecker;
import org.apache.wicket.cdi.ConversationPropagator;
import org.apache.wicket.cdi.DetachEventEmitter;
import org.apache.wicket.cdi.weld.WeldCdiContainer;
import org.apache.wicket.util.tester.WicketTester;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.jglue.cdiunit.ContextController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Simple test using the WicketTester
 */
@RunWith(CdiRunner.class)
@AdditionalClasses(value = {
    CdiConfiguration.class,
    WeldCdiContainer.class,
    ProductsModel.class,
    AbstractCdiContainer.class,
    ConversationPropagator.class,
    ConversationExpiryChecker.class,
    DetachEventEmitter.class},
    late = "org.apache.wicket.cdi.NonContextualManager")
public class TestHomePage
{
	private WicketTester tester;

    @Inject
    private ContextController contextController;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
        prepareRequest(tester.getRequest());
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		// start and render the test page
		tester.startPage(HomePage.class);

	}

    private void prepareRequest(HttpServletRequest request)
    {
        contextController.openRequest(request);
    }
}
