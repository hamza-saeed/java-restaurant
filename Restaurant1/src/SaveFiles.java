import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;

public class SaveFiles {

	// default list models to store items of each course
	DefaultListModel allStarters = new DefaultListModel();
	DefaultListModel allMains = new DefaultListModel();
	DefaultListModel allDesserts = new DefaultListModel();
	DefaultListModel allDrinks = new DefaultListModel();
	DefaultListModel allExtras = new DefaultListModel();
	DefaultListModel basket = new DefaultListModel();

	// file names
	String starterFile = "Starters.dat";
	String mainsFile = "Mains.dat";
	String dessertsFile = "Desserts.dat";
	String drinksFile = "Drinks.dat";
	String extrasFile = "Extras.dat";
	String basketFile = "Basket.dat";

	
	//method to load starters from their file
	public void loadStartersFromDisk() {
		FileInputStream in;
		try {
			in = new FileInputStream(starterFile);

			ObjectInputStream oIn = new ObjectInputStream(in);

			allStarters = (DefaultListModel) oIn.readObject();
			oIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//method to save starters to their file
	public void saveStartersToDisk() {
		FileOutputStream out;
		try {
			out = new FileOutputStream(starterFile);

			ObjectOutputStream oOut = new ObjectOutputStream(out);
			oOut.writeObject(allStarters);
			oOut.flush();
			oOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//method to load mains from their file
	public void loadMainsFromDisk() {
		FileInputStream in;
		try {
			in = new FileInputStream(mainsFile);

			ObjectInputStream oIn = new ObjectInputStream(in);

			allMains = (DefaultListModel) oIn.readObject();
			oIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//method to save mains to their file
	public void saveMainsToDisk() {
		FileOutputStream out;
		try {
			out = new FileOutputStream(mainsFile);

			ObjectOutputStream oOut = new ObjectOutputStream(out);
			oOut.writeObject(allMains);
			oOut.flush();
			oOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method to save desserts to their file
	public void saveDessertsToDisk() {
		FileOutputStream out;
		try {
			out = new FileOutputStream(dessertsFile);

			ObjectOutputStream oOut = new ObjectOutputStream(out);
			oOut.writeObject(allDesserts);
			oOut.flush();
			oOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//method to load desserts from their file
	public void loadDessertsFromDisk() {
		FileInputStream in;
		try {
			in = new FileInputStream(dessertsFile);

			ObjectInputStream oIn = new ObjectInputStream(in);

			allDesserts = (DefaultListModel) oIn.readObject();
			oIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method to save desserts to their file
	public void saveDrinksToDisk() {
		FileOutputStream out;
		try {
			out = new FileOutputStream(drinksFile);

			ObjectOutputStream oOut = new ObjectOutputStream(out);
			oOut.writeObject(allDrinks);
			oOut.flush();
			oOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//method to load drinks from their file
	public void loadDrinksFromDisk() {
		FileInputStream in;
		try {
			in = new FileInputStream(drinksFile);

			ObjectInputStream oIn = new ObjectInputStream(in);

			allDrinks = (DefaultListModel) oIn.readObject();
			oIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method to save extras to their file
	public void saveExtrasToDisk() {
		FileOutputStream out;
		try {
			out = new FileOutputStream(extrasFile);

			ObjectOutputStream oOut = new ObjectOutputStream(out);
			oOut.writeObject(allExtras);
			oOut.flush();
			oOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//method to load extras from their file
	public void loadExtrasFromDisk() {
		FileInputStream in;
		try {
			in = new FileInputStream(extrasFile);

			ObjectInputStream oIn = new ObjectInputStream(in);

			allExtras = (DefaultListModel) oIn.readObject();
			oIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//method to save basket items to their file
	public void saveBasketToDisk() {
		FileOutputStream out;
		try {
			out = new FileOutputStream(basketFile);

			ObjectOutputStream oOut = new ObjectOutputStream(out);
			oOut.writeObject(basket);
			oOut.flush();
			oOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method to load basket items from their file
	public void loadBasketFromDisk() {
		FileInputStream in;
		try {
			in = new FileInputStream(basketFile);

			ObjectInputStream oIn = new ObjectInputStream(in);

			basket = (DefaultListModel) oIn.readObject();
			oIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
