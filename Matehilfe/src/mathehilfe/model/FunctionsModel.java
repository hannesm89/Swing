package mathehilfe.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Observable;
import java.util.Properties;

import javax.swing.DefaultListModel;

import mathehilfe.CheckboxListItem;

public class FunctionsModel extends Observable {
	private Properties properties;

	private String functionInputPanel_fxInputText;

	private DefaultListModel<CheckboxListItem> myFunctionsListModel;

	public FunctionsModel() {
		loadProperties();
		setMyFunctionsListModel();
	}

	private void loadProperties() {
		Reader reader;
		try {
			reader = new FileReader(
					"C:\\Users\\HannesNB\\eclipse-workspace\\Swing\\Matehilfe\\src\\mathehilfe\\model\\resources\\mathehilfe.properties");
			properties = new Properties();
			properties.load(reader);
		} catch (FileNotFoundException e) {
			System.out.println("Properties Datei wurde nicht gefunden!");
			loadDefaultProperties();
		} catch (IOException e) {
			System.out.println("IOException:"+e);
			e.printStackTrace();
		}
	}
	
	private void loadDefaultProperties() {
		
	}

	public void addElementToMyFunctionsList() {
		myFunctionsListModel.addElement(new CheckboxListItem(functionInputPanel_fxInputText));
	}

	public void setMyFunctionsListModel() {
		myFunctionsListModel = new DefaultListModel<CheckboxListItem>();
		myFunctionsListModel.addElement(new CheckboxListItem("apple"));
		myFunctionsListModel.addElement(new CheckboxListItem("apple2"));
	}

	public DefaultListModel<CheckboxListItem> getMyFunctionsListModel() {
		return myFunctionsListModel;
	}

	public String getProperty(String name) {
		return properties.getProperty(name);
	}
	public int getPropertyInt(String name) {
		return Integer.parseInt(properties.getProperty(name));
	}

//	public String getFunctionInputPanel_fxInputText() {
//		return functionInputPanel_fxInputText;
//	}

	public void setFunctionInputPanel_fxInputText(String functionInputPanel_fxInputText) {
		this.functionInputPanel_fxInputText = functionInputPanel_fxInputText;
	}

}
