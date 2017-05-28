package fr.ekinci.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;
import javax.portlet.*;
import java.util.ArrayList;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Gokan EKINCI
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=my-first-portlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MyFirstPortlet extends MVCPortlet {
	private static final Log LOG = LogFactoryUtil.getLog(MyFirstPortlet.class);
	private static final String LOG_HEADER = "[MY-FIRST-PORTLET]";

	@Override
	public void init (PortletConfig config) throws PortletException {
		String message = "Cette méthode est exécutée à l'initialisation de la Portlet dans Liferay";
		LOG.trace(String.format("%s init() -> %s", LOG_HEADER, message));
		super.init(config);
	}

	@Override
	public void render (RenderRequest request, RenderResponse response)
		throws PortletException, java.io.IOException {
		String message = "Cette méthode est exécutée à l'affichage de la page";
		LOG.trace(String.format("%s render() -> %s", LOG_HEADER, message));

		request.setAttribute("name", "Gokan");
		request.setAttribute("age", 28);
		request.setAttribute("favoriteLanguages", new ArrayList<String>(){{
			add("Java");
			add("SQL");
			add("C");
		}});

		super.render(request, response);
	}

	@Override
	public void processAction (ActionRequest request, ActionResponse response)
		throws PortletException, java.io.IOException {
		String message = "Cette méthode est exécutée lors de la réception d'un formulaire";
		LOG.trace(String.format("%s processAction() -> %s", LOG_HEADER, message));
		LOG.trace(String.format("%s Texte du formulaire -> %s", LOG_HEADER, request.getParameter("field1")));
		super.processAction(request, response);
	}

	@ProcessAction(name = "formSentWithAlloy")
	public void formSentWithAlloy (ActionRequest request, ActionResponse response)
			throws PortletException, java.io.IOException {
		String message = "Formulaire Alloy";
		LOG.trace(String.format("%s formSentWithAlloy() -> %s", LOG_HEADER, message));
		LOG.trace(String.format("%s Texte du formulaire Alloy -> %s", LOG_HEADER, request.getParameter("field2")));
		// Ne pas utiliser super.processAction(request, response) lorsque la méthode est annoté avec `@ProcessAction`
	}

	@Override
	public void destroy () {
		String message = "Cette méthode est exécutée lors de la désinstallation de la Portlet de Liferay";
		LOG.trace(String.format("%s destroy() -> %s", LOG_HEADER, message));
		super.destroy();
	}
}