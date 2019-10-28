import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitAddingMenuItem {

	@Test
	public void testAddItemToStarter() {
		MenuItems menuItems = new MenuItems();
		try {
			// load from disk
			menuItems.loadStartersFromDisk();
			// add item for test
			menuItems.addStarter("TestStarter", 4.29, 232, true, true);
			// ensure that value is equal to one added
			assertEquals("TestStarter     £4.29     232.00 calories     true   true",
					menuItems.allStarters.getElementAt(menuItems.allStarters.getSize() - 1).toString());
		} finally {
			// clean up by removing element which was just added for testing
			// purposes
			menuItems.allStarters.removeElementAt(menuItems.allStarters.getSize() - 1);
			menuItems.saveStartersToDisk();
		}

	}

	@Test
	public void testAddItemToMain() {
		MenuItems menuItems = new MenuItems();
		try {
			// load from disk
			menuItems.loadMainsFromDisk();
			// add item for test
			menuItems.addMains("TestMain", 6.79, 422.00, false, false);
			// ensure that value is equal to one added
			assertEquals("TestMain     £6.79     422.00 calories     false   false",
					menuItems.allMains.getElementAt(menuItems.allMains.getSize() - 1).toString());
		} finally {
			// clean up by removing element which was just added for testing
			// purposes
			menuItems.allMains.removeElementAt(menuItems.allMains.getSize() - 1);
			menuItems.saveMainsToDisk();
		}

	}

	@Test
	public void testAddItemToDessert() {
		MenuItems menuItems = new MenuItems();
		try {
			// load from disk
			menuItems.loadDessertsFromDisk();
			// add item for test
			menuItems.addDesserts("TestDessert", 3.99, 376.00, false, false);
			// ensure that value is equal to one added
			assertEquals("TestDessert     £3.99     376.00 calories     false   false",
					menuItems.allDesserts.getElementAt(menuItems.allDesserts.getSize() - 1).toString());
		} finally {
			// clean up by removing element which was just added for testing
			// purposes
			menuItems.allDesserts.removeElementAt(menuItems.allDesserts.getSize() - 1);
			menuItems.saveDessertsToDisk();
		}

	}

	@Test
	public void testAddItemToDrinks() {
		MenuItems menuItems = new MenuItems();
		try {
			// load from disk
			menuItems.loadDrinksFromDisk();
			// add item for test
			menuItems.addDrinks("TestDrink", 1.79, 322.00, true, false);
			// ensure that value is equal to one added
			assertEquals("TestDrink     £1.79     322.00 calories     true   false",
					menuItems.allDrinks.getElementAt(menuItems.allDrinks.getSize() - 1).toString());
		} finally {
			// clean up by removing element which was just added for testing
			// purposes
			menuItems.allDrinks.removeElementAt(menuItems.allDrinks.getSize() - 1);
			menuItems.saveDrinksToDisk();
		}

	}

	@Test
	public void testAddItemToExtras() {
		MenuItems menuItems = new MenuItems();
		try {
			// load from disk
			menuItems.loadExtrasFromDisk();
			// add item for test
			menuItems.addExtras("TestExtra", 3.33, 452.00, false, true);
			// ensure that value is equal to one added
			assertEquals("TestExtra     £3.33     452.00 calories     false   true",
					menuItems.allExtras.getElementAt(menuItems.allExtras.getSize() - 1).toString());
		} finally {
			// clean up by removing element which was just added for testing
			// purposes
			menuItems.allExtras.removeElementAt(menuItems.allExtras.getSize() - 1);
			menuItems.saveExtrasToDisk();
		}

	}

}
