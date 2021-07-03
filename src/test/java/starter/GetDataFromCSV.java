package starter;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.google.gson.Gson;
import org.testng.Assert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class GetDataFromCSV {
	
//	public static void main(String[] args) throws IOException {
	
	public static List<SourceCSVPojo> getUserDataDataFromCSV() throws IOException {

		
			String strImportUsserDataFile = System.getProperty("user.dir") + "//src//test//resources//inputfiles//SourceCSV2.csv";
			File input = new File(strImportUsserDataFile);
			MappingIterator<SourceCSVPojo> userDataPojoIter = new CsvMapper().readerWithTypedSchemaFor(SourceCSVPojo.class).readValues(input);
		///Users/Yogita/Documents/Oldies/IMP-BKP-Webstorefront-TestAutomation/All My Automations/YogitaAssignment/src/test/resources/inputFiles/SourceCSV2.csv
			List<SourceCSVPojo> userDataPojoFromImport = userDataPojoIter	.readAll();
			for (Iterator iterator = userDataPojoFromImport.iterator(); iterator.hasNext();) {
				SourceCSVPojo userPojo = (SourceCSVPojo) iterator.next();
				//System.out.println(userPojo.getId() +"  "+userPojo.getPrice()+"  "+ userPojo.getDate()+"  "+userPojo.getProgramme()+"  "+userPojo.getName());
			}
			return userDataPojoFromImport;
	}
	
	
}