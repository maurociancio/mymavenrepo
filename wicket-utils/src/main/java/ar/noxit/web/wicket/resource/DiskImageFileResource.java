package ar.noxit.web.wicket.resource;

import java.io.FileInputStream;
import org.apache.wicket.markup.html.image.resource.DynamicImageResource;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.file.File;

/**
 * A image resource that is loaded from disk
 * 
 * @author Mauro Ciancio
 * 
 */
public class DiskImageFileResource extends DynamicImageResource {

    /**
     * Path model
     */
    private final IModel<String> pathModel;

    /**
     * Creates a new DiskImageFileResource
     * 
     * @param format
     *            image format
     * @param pathModel
     *            a path's model
     */
    public DiskImageFileResource(String format, IModel<String> pathModel) {
        super(format);
        if (pathModel == null) {
            throw new IllegalArgumentException("pathmodel cannot be null");
        }
        this.pathModel = pathModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected byte[] getImageData() {
        FileInputStream in = null;
        try {
            File f = new File(pathModel.getObject());
            in = new FileInputStream(f);
            Long length = f.length();

            byte data[] = new byte[length.intValue()];
            in.read(data, 0, length.intValue());

            return data;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }
}