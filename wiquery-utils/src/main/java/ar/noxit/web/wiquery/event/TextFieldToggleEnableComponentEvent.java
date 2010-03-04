package ar.noxit.web.wiquery.event;

import org.apache.wicket.markup.html.form.TextField;
import org.odlabs.wiquery.core.events.EventLabel;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;

public class TextFieldToggleEnableComponentEvent extends FormComponentToggleEnableEvent {

    private TextField<?> component;

    public TextFieldToggleEnableComponentEvent(TextField<?> component, EventLabel... eventLabel) {
        super(component, eventLabel);
        this.component = component;
    }

    @Override
    protected JsStatement getDisableStatement() {
        JsStatement disableStatement = super.getDisableStatement();
        JsStatement clearStatement = new JsQuery(component).$().chain("val", "''");
        return disableStatement.append("; " + clearStatement.render());
    }
}
