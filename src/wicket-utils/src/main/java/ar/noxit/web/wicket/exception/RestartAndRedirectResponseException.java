package ar.noxit.web.wicket.exception;

import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.RestartResponseException;

public class RestartAndRedirectResponseException extends RestartResponseException {

    public <C extends Page> RestartAndRedirectResponseException(Class<C> pageClass, PageParameters params) {
        super(pageClass, params);
        RequestCycle.get().setRedirect(true);
    }

    public <C extends Page> RestartAndRedirectResponseException(Class<C> pageClass) {
        super(pageClass);
        RequestCycle.get().setRedirect(true);
    }

    public RestartAndRedirectResponseException(Page page) {
        super(page);
        RequestCycle.get().setRedirect(true);
    }
}
