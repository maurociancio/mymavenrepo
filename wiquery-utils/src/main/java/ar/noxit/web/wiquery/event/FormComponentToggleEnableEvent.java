package ar.noxit.web.wiquery.event;

import org.apache.wicket.markup.html.form.FormComponent;
import org.odlabs.wiquery.core.events.EventLabel;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;

public class FormComponentToggleEnableEvent extends AbstractComponentEnableToggleEvent {

    private final FormComponent<?> component;

    public FormComponentToggleEnableEvent(FormComponent<?> component, EventLabel... eventLabel) {
        super(eventLabel);
        if (component == null) {
            throw new IllegalArgumentException("component cannot be null");
        }
        this.component = component;
    }

    @Override
    protected JsStatement getEnableStatement() {
        return new JsQuery(component).$().chain("removeAttr", "'disabled'");
    }

    @Override
    protected JsStatement getDisableStatement() {
        return new JsQuery(component).$().chain("attr", "'disabled'", "'true'");
    }
}