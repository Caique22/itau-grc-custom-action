import com.ibm.openpages.api.resource.IResource;
import com.ibm.openpages.api.resource.IField;
import com.ibm.openpages.api.resource.IStringField;
import com.ibm.openpages.api.resource.IDateField;
import com.ibm.openpages.api.resource.IIntegerField;
import com.ibm.openpages.api.workflow.actions.AbstractCustomAction;
import com.ibm.openpages.api.workflow.actions.IWFCustomAction;
import com.ibm.openpages.api.workflow.IWFFieldSetter;
import com.ibm.openpages.api.workflow.actions.IWFOperationContext;
import com.ibm.openpages.api.workflow.actions.IWFCustomProperty;
import java.util.List;
import java.util.ArrayList;

public class TestCustomAction extends AbstractCustomAction {

    public List<IWFFieldSetter> fields;

    // Constructor
    public TestCustomAction(IWFOperationContext context, List<IWFCustomProperty> properties) {
        super(context, properties);
        this.fields = new ArrayList<>();
        // Inicializar a lista de campos conforme necessário
    }

    @Override
    protected void process() throws Exception {
        System.out.println("Test Custom Action");
        // Adicionar lógica específica aqui
        List<IWFFieldSetter> inheritedFields = super.getFields();
    
        // Print fields
        for (IWFFieldSetter field : inheritedFields) {
            System.out.println(field.toString());
        }
    
    }


}
