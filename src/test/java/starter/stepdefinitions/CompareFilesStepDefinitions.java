package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.compareFiles.CompareObj;


public class CompareFilesStepDefinitions {

    @Steps
    CompareObj compareObj;

    @Given("Compare files to validate if all the xml elements are matching then pass")
    public void ifAllTheXmlElementsAreMatching() {
         compareObj.ifAllTheXmlElementsAreMatching ();
    }

    @Given("Compare files to validate if transactions blocks are matching but is not in order")
    public void ifTransactionBlocksMatchingButNotInOrder() {
        compareObj.ifTransactionBlocksMatchingButNotInOrder ();
    }

    @Given("Compare files to validate if tag names in transactions blocks are not matching")
    public void ifTagNamesInTransactionBlocksAreNotMatching() {
        compareObj.ifTagNamesInTransactionBlocksAreNotMatching ();
    }

    @Given("Compare files to validate if there is excess no of elements in transaction blocks")
    public void ifExcesssNoOfElementsInTransactionBlocks() {
        compareObj.ifExcesssNoOfElementsInTransactionBlocks ();
    }
}
