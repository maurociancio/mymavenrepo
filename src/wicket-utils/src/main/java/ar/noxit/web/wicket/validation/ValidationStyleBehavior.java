package ar.noxit.web.wicket.validation;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.util.value.IValueMap;

public class ValidationStyleBehavior extends AbstractBehavior {

    private String invalidCss;
    private String validCss;

    public ValidationStyleBehavior() {
        this("valid", "invalid");
    }

    public ValidationStyleBehavior(String validCss, String invalidCss) {
        if (validCss == null || invalidCss == null) {
            throw new IllegalArgumentException("css cannot be null");
        }
        this.validCss = validCss;
        this.invalidCss = invalidCss;
    }

    @Override
    public void bind(Component component) {
        if (!(component instanceof FormComponent<?>)) {
            throw new IllegalStateException(
                    "this behavior could only be added if the component inherits from FormComponent");
        }
    }

    @Override
    public void onComponentTag(final Component component, final ComponentTag tag) {
        FormComponent<?> comp = (FormComponent<?>) component;
        if (comp.isValid() && comp.getConvertedInput() != null) {
            addClass(tag, validCss);
        } else if (!comp.isValid()) {
            addClass(tag, invalidCss);
        }
    }

    protected void addClass(ComponentTag tag, String value) {
        IValueMap attributes = tag.getAttributes();
        CharSequence charSequence = attributes.getCharSequence("class");
        if (charSequence == null)
            attributes.put("class", value);
        else
            attributes.put("class", charSequence + " " + value);
    }
}
