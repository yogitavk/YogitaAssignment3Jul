package starter.compareFiles;

import net.serenitybdd.core.pages.PageObject;

public class CompareObj extends PageObject {

    String dir = System.getProperty("user.dir");
    String sourceFile = dir + "//src/test//resources//" + "Source_File.xml";
    String destinationFile = dir + "//src/test//resources//" +"Target_File.xml";

    public void ifAllTheXmlElementsAreMatching() {
        try {
            XmlUtilities.xmlComparator(sourceFile, destinationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ifTransactionBlocksMatchingButNotInOrder() {
        try {
            XmlUtilities.xmlComparatorWithSort(sourceFile, destinationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ifTagNamesInTransactionBlocksAreNotMatching() {
        try {
            XmlUtilities.xmlComparatorForTagsInTransactions(sourceFile, destinationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ifExcesssNoOfElementsInTransactionBlocks() {
        try {
            XmlUtilities.xmlComparatorForExcesssNoOfElementsInTransactionBlocks(sourceFile, destinationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
