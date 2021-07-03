package starter.compareFiles;

import jdk.internal.org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.assertj.core.api.SoftAssertions;
import org.custommonkey.xmlunit.*;
import org.custommonkey.xmlunit.examples.RecursiveElementNameAndTextQualifier;
import org.testng.Assert;
import org.xml.sax.InputSource;
import java.util.Iterator;
import org.testng.asserts.SoftAssert;

import static junit.framework.Assert.assertTrue;
import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

public class XmlUtilities {

    public static void main(String[] args) throws IOException, SAXException, org.xml.sax.SAXException {
        String dir = System.getProperty("user.dir");
        String sourceFile = dir + "//src/test//resources//" + "Source_File.xml";
        String destinationFile = dir + "//src/test//resources//" + "Target_File.xml";
        xmlComparator(sourceFile, destinationFile);
    }

    public static void xmlComparator(String expectedXmlFilePath, String currentXmlFilePath) throws SAXException, IOException, org.xml.sax.SAXException {
        //ignore while space differances
        XMLUnit.setIgnoreWhitespace(true);
        //ignore attribute order
        XMLUnit.setIgnoreAttributeOrder(true);
        //ignore comment differances
        XMLUnit.setIgnoreComments(true);
        //ignore differance on CData and text
        XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);

        InputSource expected = new InputSource(expectedXmlFilePath);
        InputSource current = new InputSource(currentXmlFilePath);

        DetailedDiff detailedDiff = new DetailedDiff(new Diff(expected, current));

        //ignore the sorting mismatch issues
        detailedDiff.overrideElementQualifier(new RecursiveElementNameAndTextQualifier());

        //this will print even if order mismatch elements are there. if you want to skip this use assertor
        Iterator i = detailedDiff.getAllDifferences().iterator();
        while (i.hasNext()) {
            System.out.println(i.next().toString());
        }
        System.out.println("================== if soarting issues are ignored =============================");
        //this can use ignore soarting issues and assert
        assertXMLEqual("XML files are mismatch", detailedDiff, true);

    }


    public static void xmlComparatorWithSort(String expectedXmlFilePath, String currentXmlFilePath) throws IOException, org.xml.sax.SAXException {
        //ignore while space differances
        XMLUnit.setIgnoreWhitespace(true);
        //ignore attribute order
        XMLUnit.setIgnoreAttributeOrder(true);
        //ignore comment differances
        XMLUnit.setIgnoreComments(true);
        //ignore differance on CData and text
        XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);

        InputSource expected = new InputSource(expectedXmlFilePath);
        InputSource current = new InputSource(currentXmlFilePath);

        DetailedDiff detailedDiff = new DetailedDiff(new Diff(expected, current));

        //ignore the sorting mismatch issues
        detailedDiff.overrideElementQualifier(new RecursiveElementNameAndTextQualifier());

        //this will print even if order mismatch elements are there. if you want to skip this use assertor
        SoftAssert softAssert = new SoftAssert();

        Iterator i = detailedDiff.getAllDifferences().iterator();
        StringBuffer sb = new StringBuffer();
        while (i.hasNext()) {
            String diffStr = i.next().toString();
            if(diffStr.contains("Expected sequence")) {
                System.out.println("In Expected sequence" +diffStr);
                sb.append(diffStr);
                sb.append("\n");
            }
        }
        Assert.assertEquals(sb.toString(), "");
    }

    public static void xmlComparatorForTagsInTransactions(String expectedXmlFilePath, String currentXmlFilePath) throws IOException, org.xml.sax.SAXException {
        //ignore while space differances
        XMLUnit.setIgnoreWhitespace(true);
        //ignore attribute order
        XMLUnit.setIgnoreAttributeOrder(true);
        //ignore comment differances
        XMLUnit.setIgnoreComments(true);
        //ignore differance on CData and text
        XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);

        InputSource expected = new InputSource(expectedXmlFilePath);
        InputSource current = new InputSource(currentXmlFilePath);

        DetailedDiff detailedDiff = new DetailedDiff(new Diff(expected, current));

        //ignore the sorting mismatch issues
        detailedDiff.overrideElementQualifier(new RecursiveElementNameAndTextQualifier());

        //this will print even if order mismatch elements are there. if you want to skip this use assertor
        SoftAssert softAssert = new SoftAssert();

        Iterator i = detailedDiff.getAllDifferences().iterator();
        StringBuffer sb = new StringBuffer();
        while (i.hasNext()) {
            String diffStr = i.next().toString();
            if(diffStr.contains("Expected element tag name")) {
                System.out.println("In Expected element tag name " +diffStr);
                sb.append(diffStr);
                sb.append("\n");
            }
        }
        Assert.assertEquals(sb.toString(), "");
    }

    public static void xmlComparatorForExcesssNoOfElementsInTransactionBlocks(String expectedXmlFilePath, String currentXmlFilePath) throws IOException, org.xml.sax.SAXException {
        //ignore while space differances
        XMLUnit.setIgnoreWhitespace(true);
        //ignore attribute order
        XMLUnit.setIgnoreAttributeOrder(true);
        //ignore comment differances
        XMLUnit.setIgnoreComments(true);
        //ignore differance on CData and text
        XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);

        InputSource expected = new InputSource(expectedXmlFilePath);
        InputSource current = new InputSource(currentXmlFilePath);

        DetailedDiff detailedDiff = new DetailedDiff(new Diff(expected, current));

        //ignore the sorting mismatch issues
        detailedDiff.overrideElementQualifier(new RecursiveElementNameAndTextQualifier());

        //this will print even if order mismatch elements are there. if you want to skip this use assertor
        SoftAssert softAssert = new SoftAssert();

        Iterator i = detailedDiff.getAllDifferences().iterator();
        StringBuffer sb = new StringBuffer();
        while (i.hasNext()) {
            String diffStr = i.next().toString();
            if(diffStr.contains("Expected number of child")) {
                System.out.println("In Expected number of child " +diffStr);
                sb.append(diffStr);
                sb.append("\n");
            }
        }
        Assert.assertEquals(sb.toString(), "");
    }
}