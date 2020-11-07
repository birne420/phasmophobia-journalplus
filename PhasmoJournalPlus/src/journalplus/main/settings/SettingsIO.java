package journalplus.main.settings;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import journalplus.gui.themes.ActualTheme;
import journalplus.gui.themes.ThemeLoader;
import journalplus.utility.BasicUtility;

public class SettingsIO {
	public static final String CONFIG_FILE = "JournalPlus.cfg";

	private static final String CONFIG_XML_BASE = "journal_plus_config";
	private static final String CONFIG_XML_WINDOWSIZESCALE = "window_scaling";
	private static final String CONFIG_XML_THEME = "active_theme";
	private static final String CONFIG_XML_LIVELIST = "livelist_enabled";
	private static final String CONFIG_XML_AUSWERTUNG_DEFJA = "evaluation_def_yes";
	private static final String CONFIG_XML_AUSWERTUNG_VERJA = "evaluation_prob_yes";
	private static final String CONFIG_XML_AUSWERTUNG_VERNEIN = "evaluation_prob_no";
	private static final String CONFIG_XML_AUSWERTUNG_DEFNEIN = "evaluation_def_no";
	private static final String CONFIG_XML_AUSWERTUNG_DEFJA2 = "evaluation_def_yes_2";
	private static final String CONFIG_XML_AUSWERTUNG_DEFNEIN2 = "evaluation_def_no_2";

	private static String settingWindowSizeScale = "64";
	private static String settingTheme = "default";
	private static String settingLiveList = "true";
	private static String configVersion = null;
	
	private static String settingAuswertungFaktorDefJa = "2.0";
	private static String settingAuswertungFaktorVerJa = "1.2";
	private static String settingAuswertungFaktorVerNein = "0.8";
	private static String settingAuswertungFaktorDefNein = "0.0";
	
	private static String settingAuswertungFaktorDefJa2 = "4.0";
	private static String settingAuswertungFaktorDefNein2 = "0.64";
	
	public static void setWindowSizeScale(int scale) {
		settingWindowSizeScale = "" + scale;
	}
	public static int getWindowSizeScale() {
		init();
		return Integer.parseInt(settingWindowSizeScale);
	}
	public static void setTheme(String themeId) {
		settingTheme = themeId;
	}
	public static ActualTheme getTheme() {
		init();
		String themeId = settingTheme.toLowerCase();
		
		ThemeLoader loader = new ThemeLoader();
		if(!loader.loadTheme(themeId)) {
			loader.loadTheme("default");
		}
		ActualTheme theme = loader.get();
		return theme;
	}
	public static void setLiveList(boolean bool) {
		settingLiveList = "" + bool;
	}
	public static boolean getLiveList() {
		init();
		if(settingLiveList.toLowerCase().equals("true")) {
			return true;
		}
		return false;
	}
	public static void setAuswertungFaktorDefJa(String faktor) {
		settingAuswertungFaktorDefJa = faktor;
	}
	public static double getAuswertungFaktorDefJa() {
		return BasicUtility.strToDouble(settingAuswertungFaktorDefJa);
	}
	public static void setAuswertungFaktorVerJa(String faktor) {
		settingAuswertungFaktorVerJa = faktor;
	}
	public static double getAuswertungFaktorVerJa() {
		return BasicUtility.strToDouble(settingAuswertungFaktorVerJa);
	}
	public static void setAuswertungFaktorVerNein(String faktor) {
		settingAuswertungFaktorVerNein = faktor;
	}
	public static double getAuswertungFaktorVerNein() {
		return BasicUtility.strToDouble(settingAuswertungFaktorVerNein);
	}
	public static void setAuswertungFaktorDefNein(String faktor) {
		settingAuswertungFaktorDefNein = faktor;
	}
	public static double getAuswertungFaktorDefNein() {
		return BasicUtility.strToDouble(settingAuswertungFaktorDefNein);
	}
	public static void setAuswertungFaktorDefJa2(String faktor) {
		settingAuswertungFaktorDefJa2 = faktor;
	}
	public static double getAuswertungFaktorDefJa2() {
		return BasicUtility.strToDouble(settingAuswertungFaktorDefJa2);
	}
	public static void setAuswertungFaktorDefNein2(String faktor) {
		settingAuswertungFaktorDefNein2 = faktor;
	}
	public static double getAuswertungFaktorDefNein2() {
		return BasicUtility.strToDouble(settingAuswertungFaktorDefNein2);
	}
	
	public static void saveSets() {
		saveConfig();
	}
	public static boolean init() {
		File file = new File(CONFIG_FILE);
		if(!(file.exists() && !file.isDirectory())) {
			saveConfig();
		}

		return loadConfig();
	}
	
	//TODO: ConfigVersionCheck
	public static boolean configVersionCheck() {
		return configVersion.equalsIgnoreCase(Settings.EINSTELLUNG_VERSION_STRING);
	}

	private static boolean loadConfig() {
		File settingsFile = new File(CONFIG_FILE);
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return false;
		}
		Document document;
		try {
			document = documentBuilder.parse(settingsFile);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
			return false;
		}
		NodeList list = document.getElementsByTagName(CONFIG_XML_BASE);
		for(int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				configVersion = element.getElementsByTagName("cfg_version").item(0).getTextContent();
				
				try {
					settingWindowSizeScale = element.getElementsByTagName(CONFIG_XML_WINDOWSIZESCALE).item(0).getTextContent();
					settingTheme = element.getElementsByTagName(CONFIG_XML_THEME).item(0).getTextContent();
					settingLiveList = element.getElementsByTagName(CONFIG_XML_LIVELIST).item(0).getTextContent();
					settingAuswertungFaktorDefJa = element.getElementsByTagName(CONFIG_XML_AUSWERTUNG_DEFJA).item(0).getTextContent();
					settingAuswertungFaktorVerJa = element.getElementsByTagName(CONFIG_XML_AUSWERTUNG_VERJA).item(0).getTextContent();
					settingAuswertungFaktorVerNein = element.getElementsByTagName(CONFIG_XML_AUSWERTUNG_VERNEIN).item(0).getTextContent();
					settingAuswertungFaktorDefNein = element.getElementsByTagName(CONFIG_XML_AUSWERTUNG_DEFNEIN).item(0).getTextContent();
					settingAuswertungFaktorDefJa2 = element.getElementsByTagName(CONFIG_XML_AUSWERTUNG_DEFJA2).item(0).getTextContent();
					settingAuswertungFaktorDefNein2 = element.getElementsByTagName(CONFIG_XML_AUSWERTUNG_DEFNEIN2).item(0).getTextContent();
					return true;
				} catch(NullPointerException nullPtrExc) {
					if(configVersionCheck()) {
						JOptionPane.showMessageDialog(null, "Einstellungen wurden zurückgesetzt, da die Konfigurationsdatei beschädigt war.", "Einstellungen", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Einstellungen wurden zurückgesetzt, da sich das Konfigurationsformat in der neuen Version geändert hat.", "Einstellungen", JOptionPane.INFORMATION_MESSAGE);
					}
					deleteConfig();
					init();
					return false;
				}
			}
		}
		return false;
	}
	private static boolean saveConfig() {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
			return false;
		}
		Document document = documentBuilder.newDocument();
		Element elementConfig = document.createElement(CONFIG_XML_BASE);
		
		Element elementConfigVersion = document.createElement("cfg_version");
		elementConfigVersion.setTextContent(Settings.EINSTELLUNG_VERSION_STRING);
		
		Element elementConfigWindowSizeScale = document.createElement(CONFIG_XML_WINDOWSIZESCALE);
		elementConfigWindowSizeScale.setTextContent(settingWindowSizeScale);
		
		Element elementConfigTheme = document.createElement(CONFIG_XML_THEME);
		elementConfigTheme.setTextContent(settingTheme);
		
		Element elementConfigLiveList = document.createElement(CONFIG_XML_LIVELIST);
		elementConfigLiveList.setTextContent(settingLiveList);
		
		Element elementConfigAuswertungDefJa = document.createElement(CONFIG_XML_AUSWERTUNG_DEFJA);
		elementConfigAuswertungDefJa.setTextContent(settingAuswertungFaktorDefJa);
		
		Element elementConfigAuswertungVerJa = document.createElement(CONFIG_XML_AUSWERTUNG_VERJA);
		elementConfigAuswertungVerJa.setTextContent(settingAuswertungFaktorVerJa);
		
		Element elementConfigAuswertungVerNein = document.createElement(CONFIG_XML_AUSWERTUNG_VERNEIN);
		elementConfigAuswertungVerNein.setTextContent(settingAuswertungFaktorVerNein);
		
		Element elementConfigAuswertungDefNein = document.createElement(CONFIG_XML_AUSWERTUNG_DEFNEIN);
		elementConfigAuswertungDefNein.setTextContent(settingAuswertungFaktorDefNein);
		
		Element elementConfigAuswertungDefJa2 = document.createElement(CONFIG_XML_AUSWERTUNG_DEFJA2);
		elementConfigAuswertungDefJa2.setTextContent(settingAuswertungFaktorDefJa2);
		
		Element elementConfigAuswertungDefNein2 = document.createElement(CONFIG_XML_AUSWERTUNG_DEFNEIN2);
		elementConfigAuswertungDefNein2.setTextContent(settingAuswertungFaktorDefNein2);
		
		elementConfig.appendChild(elementConfigVersion);
		elementConfig.appendChild(elementConfigWindowSizeScale);
		elementConfig.appendChild(elementConfigTheme);
		elementConfig.appendChild(elementConfigLiveList);
		elementConfig.appendChild(elementConfigAuswertungDefJa);
		elementConfig.appendChild(elementConfigAuswertungVerJa);
		elementConfig.appendChild(elementConfigAuswertungVerNein);
		elementConfig.appendChild(elementConfigAuswertungDefNein);
		elementConfig.appendChild(elementConfigAuswertungDefJa2);
		elementConfig.appendChild(elementConfigAuswertungDefNein2);
		
		document.appendChild(elementConfig);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			return false;
		}
		DOMSource source = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File(CONFIG_FILE));
		try {
			transformer.transform(source, streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static void deleteConfig() {
		new File(CONFIG_FILE).delete();
	}
}
