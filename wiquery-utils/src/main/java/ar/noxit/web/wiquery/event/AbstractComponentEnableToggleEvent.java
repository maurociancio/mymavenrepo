package ar.noxit.web.wiquery.event;

import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.events.EventLabel;
import org.odlabs.wiquery.core.events.Event;

public abstract class AbstractComponentEnableToggleEvent extends Event {

    public AbstractComponentEnableToggleEvent(EventLabel... eventLabels) {
        super(eventLabels);
    }

    @Override
    public JsScope callback() {
        JsStatement enableScope = getEnableStatement();
        JsStatement disableScope = getDisableStatement();
    
        String js = String.format(
                "if ($(this).attr('checked')) {                         \n" +
                "     %s                                                \n" +
                "} else {                                               \n" +
                "     %s                                                \n" +
                "}                                                      \n",
                enableScope.render(), 
                disableScope.render());

        return JsScope.quickScope(js);
    }

    protected abstract JsStatement getDisableStatement();

    protected abstract JsStatement getEnableStatement();
}