package net.d4rkfly3r.maps;

import net.d4rkfly3r.maps.info.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;

public class Loader {

    private final Document document;

    public Loader(final Path mapPath) throws ParserConfigurationException, IOException, SAXException {
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        this.document = documentBuilder.parse(mapPath.toFile());
    }


    public Map parse() {
        this.document.normalize();

        final Element mapElement = this.document.getDocumentElement();
        final Map loadedMap = new Map(mapElement.getAttribute("id"), mapElement.getAttribute("name"), mapElement.getAttribute("type"), mapElement.getAttribute("asset-pack"));

        final NodeList childNodes = mapElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            final Node node = childNodes.item(i);
            final String nodeName = node.getNodeName();
            final NamedNodeMap nodeAttributes = node.getAttributes();

            if (nodeName.equalsIgnoreCase("author")) {
                final String authorName = nodeAttributes.getNamedItem("name").getNodeValue();
                final String authorUsername = nodeAttributes.getNamedItem("username").getNodeValue();
                loadedMap.addAuthor(new Author(authorName, authorUsername));
            } else if (nodeName.equalsIgnoreCase("game")) {
                loadedMap.addGame(this.parseGame(node, nodeAttributes));
            } else {
                parseCommonNodes(loadedMap, node, nodeName, nodeAttributes);
            }
        }

        System.out.println(loadedMap);
        return loadedMap;
    }

    private void parseCommonNodes(final InfoHolder infoHolder, final Node node, final String nodeName, final NamedNodeMap nodeAttributes) {
        if (nodeName.equalsIgnoreCase("team")) {
            final String teamID = nodeAttributes.getNamedItem("id").getNodeValue();
            final String teamName = nodeAttributes.getNamedItem("name").getNodeValue();
            infoHolder.addTeam(new Team(teamID, teamName));
        } else if (nodeName.equalsIgnoreCase("zone")) {
            infoHolder.addZone(this.parseZone(node, nodeAttributes));
        } else if (nodeName.equalsIgnoreCase("spawns")) {
            infoHolder.addSpawns(this.parseSpawns(node, nodeAttributes));
        }
    }

    private Spawns parseSpawns(final Node spawnNode, final NamedNodeMap spawnNodeAttributes) {
        final String spawnTeam = spawnNodeAttributes.getNamedItem("team").getNodeValue();
        Spawns spawns = new Spawns(spawnTeam);

        final NodeList childNodes = spawnNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            final Node childNode = childNodes.item(i);
            final String childNodeName = childNode.getNodeName();
            final NamedNodeMap childNodeAttributes = childNode.getAttributes();
            if (childNodeName.equalsIgnoreCase("region")) {
                spawns.addRegion(this.parseRegion(childNode));
            } else if (childNodeName.equalsIgnoreCase("point")) {
                spawns.addPoint(this.parsePoint(childNode));
            }
        }

        return spawns;
    }

    private Game parseGame(final Node gameNode, final NamedNodeMap gameNodeAttributes) {
        final String gameID = gameNodeAttributes.getNamedItem("id").getNodeValue();
        final String gameName = gameNodeAttributes.getNamedItem("name").getNodeValue();
        final Game game = new Game(gameID, gameName);

        final NodeList childNodes = gameNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            final Node childNode = childNodes.item(i);
            final String childNodeName = childNode.getNodeName();
            final NamedNodeMap childNodeAttributes = childNode.getAttributes();
            parseCommonNodes(game, childNode, childNodeName, childNodeAttributes);
        }
        return game;
    }

    private Zone parseZone(final Node zoneNode, final NamedNodeMap nodeAttributes) {
        final String zoneID = nodeAttributes.getNamedItem("id").getNodeValue();
        final String zoneName = nodeAttributes.getNamedItem("name").getNodeValue();
        final Zone zone = new Zone(zoneID, zoneName);

        final NodeList zoneChildNodes = zoneNode.getChildNodes();
        for (int i = 0; i < zoneChildNodes.getLength(); i++) {
            final Node zoneChildNode = zoneChildNodes.item(i);
            if (zoneChildNode.getNodeName().equalsIgnoreCase("region")) {
                zone.addRegion(parseRegion(zoneChildNode));
            }
        }

        return zone;
    }

    private Region parseRegion(final Node node) {
        final Node regionWeightNode = node.getAttributes().getNamedItem("w");
        final Region region = new Region(regionWeightNode == null ? "-1" : regionWeightNode.getNodeValue());

        final NodeList regionChildNodes = node.getChildNodes();
        for (int j = 0; j < regionChildNodes.getLength(); j++) {
            final Node regionChildNode = regionChildNodes.item(j);
            if (regionChildNode.getNodeName().equalsIgnoreCase("point")) {
                region.addPoint(this.parsePoint(regionChildNode));
            }
        }
        return region;
    }

    private Point parsePoint(final Node pointNode) {
        final NamedNodeMap pointNodeAttributes = pointNode.getAttributes();
        final Node xNode = pointNodeAttributes.getNamedItem("x");
        final Node yNode = pointNodeAttributes.getNamedItem("y");
        final Node zNode = pointNodeAttributes.getNamedItem("z");
        final Node rNode = pointNodeAttributes.getNamedItem("r");
        final Node wNode = pointNodeAttributes.getNamedItem("w");

        return new Point(((xNode == null) ? "\0" : xNode.getNodeValue()), ((yNode == null) ? "\0" : yNode.getNodeValue()), ((zNode == null) ? "\0" : zNode.getNodeValue()), ((rNode == null) ? "\0" : rNode.getNodeValue()), ((wNode == null) ? "\0" : wNode.getNodeValue()));
    }
}
