

public class Clerk {
	private class Terminal{
		private Catalog catalog;
		private Terminal(Catalog catalog) {
			this.catalog = catalog; 
		}
	}
	Terminal terminal;
	
	public Clerk() {
		this.terminal = new Terminal(new Catalog());
	}
	
	public void simulateScenario() {
//		terminal.catalog.makeNewBook("Test auth", "test title", "test bublisher", "2013", "12345");
	}

}
