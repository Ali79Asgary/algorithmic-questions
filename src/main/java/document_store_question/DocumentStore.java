package document_store_question;

import java.util.*;

public class DocumentStore {
    private Collection<String> documents = new ArrayList<String>();
    private int capacity;

    public DocumentStore(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public Collection<String> getDocuments() {
        return Collections.unmodifiableCollection(documents);
    }

    public void addDocument(String document) {
        if (this.documents.size() >= capacity)
            throw new IllegalStateException();

        documents.add(document);
    }

    @Override
    public String toString() {
        return String.format("Document store: %d/%d", documents.size(), capacity);
    }

    public static void main(String[] args) {
        DocumentStore documentStore = new DocumentStore(2);
        documentStore.addDocument("sample document");
        Collection<String> collection = documentStore.getDocuments();
        System.out.println();
    }
}
