package journalplus.main.settings;

import java.io.File;
import java.io.IOException;

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

import journalplus.themes.AbstractTheme;
import journalplus.themes.DarkTheme;
import journalplus.themes.DefaultTheme;

public class SettingsIO {
	public static final String CONFIG_FILE = "PhasmoJournalConfig.xml";

	private static final String CONFIG_XML_BASE = "JournalPlus.cfg";
	private static final String CONFIG_XML_WINDOWSIZESCALE = "WindowSizeScale";
	private static final String CONFIG_XML_THEME = "Theme";
	private static final String CONFIG_XML_LIVELIST = "LiveList";

	private static String settingWindowSizeScale = "64";
	private static String settingTheme = "default";
	private static String settingLiveList = "true";
	private static String configVersion = null;
	
	public static void setWindowSizeScale(int scale) {
		settingWindowSizeScale = "" + scale;
	}
	public static int getWindowSizeScale() {
		init();
		return Integer.parseInt(settingWindowSizeScale);
	}
	public static void setTheme(AbstractTheme theme) {
		settingTheme = theme.getThemeName();
	}
	public static AbstractTheme getTheme() {
		init();
		AbstractTheme defaultTheme = new DefaultTheme();
		AbstractTheme darkTheme = new DarkTheme();
		if(settingTheme.toLowerCase().equals(darkTheme.getThemeName())) return darkTheme;
		return defaultTheme;
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
				settingWindowSizeScale = element.getElementsByTagName(CONFIG_XML_WINDOWSIZESCALE).item(0).getTextContent();
				settingTheme = element.getElementsByTagName(CONFIG_XML_THEME).item(0).getTextContent();
				settingLiveList = element.getElementsByTagName(CONFIG_XML_LIVELIST).item(0).getTextContent();
				return true;
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
		elementConfig.appendChild(elementConfigVersion);
		elementConfig.appendChild(elementConfigWindowSizeScale);
		elementConfig.appendChild(elementConfigTheme);
		elementConfig.appendChild(elementConfigLiveList);
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
