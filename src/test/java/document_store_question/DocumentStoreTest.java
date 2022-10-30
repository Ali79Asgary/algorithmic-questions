package document_store_question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class DocumentStoreTest {
    @Test
    public void addDocument_StoreIsFull_IllegalStateExceptionThrown() {
        DocumentStore documentStore = new DocumentStore(0);
        Assertions.assertThrows(IllegalStateException.class, () -> documentStore.addDocument("sample document"));
    }

    @Test
    public void getDocument_ModifyDocument_Unsuccessful() {
        DocumentStore documentStore = new DocumentStore(1);
        documentStore.addDocument("sample document");
        Collection<String> collection = documentStore.getDocuments();
        Assertions.assertThrows(UnsupportedOperationException.class, ()->collection.add("new document"));
    }

    @Test
    public void toString_CheckFormat() {
        DocumentStore documentStore = new DocumentStore(2);
        documentStore.addDocument("sample document");
        String result = documentStore.toString();
        Assertions.assertEquals(result, "Document store: 1/2");
    }
}
