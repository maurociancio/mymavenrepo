package ar.noxit.web.wicket.validation;

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.validation.AbstractFormValidator;
import org.apache.wicket.validation.ValidationError;

public abstract class RelatedFieldsValidator<T> extends AbstractFormValidator {

    private FormComponent<T>[] components;

    @SuppressWarnings("unchecked")
    public RelatedFieldsValidator(FormComponent<?>[] components) {
        if (components == null || components.length == 0) {
            throw new IllegalArgumentException("components array cannot be null or have zero elements");
        }
        this.components = (FormComponent<T>[]) components;
    }

    @Override
    public final void validate(Form<?> form) {
        List<T> inputs = new ArrayList<T>(components.length);
        for (int i = 0; i < components.length; ++i) {
            inputs.add(components[i].getConvertedInput());
        }

        if (!validate(form, inputs)) {
            ValidationError ve = new ValidationError();
            ve.addMessageKey(resourceKey());
            ve.setVariables(variablesMap());
            form.error(form.getLocalizer().getString(resourceKey(), form));
        }
    }

    protected abstract boolean validate(Form<?> form, List<T> inputs);

    @Override
    public FormComponent<?>[] getDependentFormComponents() {
        return components;
    }
}