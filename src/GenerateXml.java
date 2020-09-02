import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

// https://examples.javacodegeeks.com/core-java/xml/parsers/documentbuilderfactory/create-xml-file-in-java-using-dom-parser-example/
// https://www.journaldev.com/1112/how-to-write-xml-file-in-java-dom-parser
public class GenerateXml {
    private String path;
    private List<Athlete> athletes;
    private DOMSource domSource;

    public GenerateXml(List<Athlete> athletes, String path) {
        this.athletes = athletes;
        this.path = path;
    }

    public void generate() {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
//            document.setXmlStandalone(true);
            ProcessingInstruction pi = document.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"Decathlon_output.xsl\"");

            // 0 Competition
            Element rootElement = document.createElement("competition");
            document.appendChild(rootElement);
            document.insertBefore(pi, rootElement);

            // Iterate Athletes
            Element athletesElement = document.createElement("athletes");
            rootElement.appendChild(athletesElement);
            for (Athlete athlete : athletes) {
                athletesElement.appendChild(getAthleteElements(document, athlete));
            }

            // CREATE THE XML FILE
            this.domSource = new DOMSource(document);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            StreamResult streamResult = new StreamResult(new File(this.path));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(this.domSource, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void prettySave() {
        try {
            StreamResult streamResult = new StreamResult(new File(this.path));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", 2);

            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(this.domSource, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private Node getAthleteElements(Document document, Athlete athlete) {
        Element athleteElement = document.createElement("athlete");
//        athleteElement.setAttribute("name", athlete.getFullName());
//        athleteElement.setAttribute("place", athlete.getPlace());

        Element athleteName = document.createElement("name");
        athleteName.appendChild(document.createTextNode(athlete.getFullName()));
        athleteElement.appendChild(athleteName);

        Element athletePlace = document.createElement("place");
        athletePlace.appendChild(document.createTextNode(athlete.getPlace()));
        athleteElement.appendChild(athletePlace);

        Element athleteTotalScore = document.createElement("total_score");
        athleteTotalScore.appendChild(document.createTextNode(String.valueOf(athlete.getTotalScore())));
        athleteElement.appendChild(athleteTotalScore);

        // Iterate Athelete Events
        Element athleteEvents = document.createElement("events");
        athleteElement.appendChild(athleteEvents);
        for (Event event : athlete.getEvents()) {
            athleteEvents.appendChild(getEventElements(document, event));
        }
        return athleteElement;
    }

    private Node getEventElements(Document document, Event event) {
        Element eventElement = document.createElement("event");
        eventElement.setAttribute("name", event.getEventConstants().getName());
        eventElement.setAttribute("score", String.valueOf(event.getScore()));
        String prettyPerformanceValue = Helper.prettyPerformanceValue(event.getPerformance(), event.getEventConstants().getUnits());
        eventElement.setAttribute("performance", prettyPerformanceValue);
//        eventElement.setAttribute("performance", String.valueOf(event.getPerformance()));
//        eventElement.setAttribute("unit", event.getEventConstants().getUnits());
        return eventElement;
    }
}
