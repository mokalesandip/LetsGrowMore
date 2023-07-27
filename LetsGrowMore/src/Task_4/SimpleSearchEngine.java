package Task_4;


	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class SimpleSearchEngine {
	    private List<String> documents;

	    public SimpleSearchEngine() {
	        documents = new ArrayList<>();
	    }

	    public void addDocument(String document) {
	        documents.add(document);
	    }

	    public List<String> search(String keyword) {
	        List<String> results = new ArrayList<>();

	        for (String document : documents) {
	            if (document.toLowerCase().contains(keyword.toLowerCase())) {
	                results.add(document);
	            }
	        }

	        return results;
	    }

	    public static void main(String[] args) {
	        SimpleSearchEngine searchEngine = new SimpleSearchEngine();

	        // Adding sample documents
	        searchEngine.addDocument("This is the first document.");
	        searchEngine.addDocument("Here is another document containing the keyword.");
	        searchEngine.addDocument("A third document that does not have the keyword.");

	        // Get user input for the search term
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the keyword to search: ");
	        String keyword = scanner.nextLine();

	        // Perform the search
	        List<String> searchResults = searchEngine.search(keyword);

	        // Display search results
	        if (searchResults.isEmpty()) {
	            System.out.println("No documents found containing the keyword.");
	        } else {
	            System.out.println("Documents containing the keyword:");
	            for (String result : searchResults) {
	                System.out.println("- " + result);
	            }
	        }
	    }
	}



