import com.ibm.openpages.api.model.IResource;
import com.ibm.openpages.api.model.IField;
import com.ibm.openpages.api.model.IStringField;
import com.ibm.openpages.api.model.IDateField;
import com.ibm.openpages.api.model.IIntegerField;
import com.ibm.openpages.api.workflow.IWFOperationContext;
import com.ibm.openpages.api.workflow.IWFCustomProperty;
import java.util.List;
import java.util.Map;

public class TestCustomAction extends AbstractCustomAction {

    // Constructor
    public TestCustomAction(IWFOperationContext context, List<IWFCustomProperty> properties) {
        super(context, properties);
        // Initialize the serviceFactory
    }

    @Override
    protected void process() throws Exception {
        System.out.println("Test Custom Action");

        // Get the resource from the context (assuming context has access to a resource, e.g., a 'parent' resource)
        IResource resource = getResourceFromContext(); // You may need to implement this method to fetch the resource
        
        // Retrieve and print all fields associated with the resource
        printAllFields(resource);
    }

    private IResource getResourceFromContext() {
        // This method needs to be implemented based on how the resource is accessible in the context.
        // Assuming that we get the resource directly from the context (you may need to adjust based on your scenario).
        // Placeholder for getting the resource, update it with your logic:
        return context.getResource();  // Update with actual logic to fetch the resource from context
    }

    private void printAllFields(IResource resource) {
        // Get all fields for the given resource
        Map<String, IField> fields = resource.getFields();

        // Iterate over the fields and print their IDs and values
        for (Map.Entry<String, IField> entry : fields.entrySet()) {
            String fieldId = entry.getKey();  // The ID of the field
            IField field = entry.getValue();  // The field object itself
            
            if (field instanceof IStringField) {
                IStringField stringField = (IStringField) field;
                System.out.println("String Field ID: " + fieldId + " - Value: " + stringField.getValue());
            } else if (field instanceof IDateField) {
                IDateField dateField = (IDateField) field;
                System.out.println("Date Field ID: " + fieldId + " - Value: " + dateField.getValue());
            } else if (field instanceof IIntegerField) {
                IIntegerField integerField = (IIntegerField) field;
                System.out.println("Integer Field ID: " + fieldId + " - Value: " + integerField.getValue());
            } else {
                System.out.println("Unknown Field Type for Field ID: " + fieldId);
            }
        }
    }
}