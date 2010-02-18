package ar.noxit.web.wicket;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;

/**
 * A static image that renders its src tag from a model
 * 
 * @author Mauro Ciancio
 * 
 */
public class StaticImage extends WebComponent {

    /**
     * src's model
     */
    private IModel<String> model = null;

    /**
     * 
     * @param id
     *            component id
     * @param model
     *            to get the src's url from
     */
    public StaticImage(String id, IModel<String> model) {
        super(id);
        if (model == null) {
            throw new IllegalArgumentException("model cannot be null");
        }

        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        checkComponentTag(tag, "img");
        tag.put("src", model.getObject());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onDetach() {
        super.onDetach();
        model.detach();
    }
}