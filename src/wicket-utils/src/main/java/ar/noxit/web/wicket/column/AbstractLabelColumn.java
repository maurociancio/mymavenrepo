package ar.noxit.web.wicket.column;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * A column that displays a label using a model
 * 
 * @author Mauro Ciancio
 * 
 * @param <T>
 *            type
 */
public abstract class AbstractLabelColumn<T> extends AbstractColumn<T> {

    /**
     * 
     * @param displayModel
     */
    public AbstractLabelColumn(IModel<String> displayModel) {
        super(displayModel);
    }

    /**
     * 
     * @param displayModel
     * @param sortProperty
     */
    public AbstractLabelColumn(IModel<String> displayModel, String sortProperty) {
        super(displayModel, sortProperty);
    }

    @Override
    public void populateItem(Item<ICellPopulator<T>> cellItem, String componentId, IModel<T> rowModel) {
        cellItem.add(new Label(componentId, createDisplayModel(rowModel)));
    }

    /**
     * 
     * @param rowModel
     * @return
     */
    protected abstract IModel<String> createDisplayModel(IModel<T> rowModel);
}
