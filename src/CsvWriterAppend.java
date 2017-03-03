import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.csvreader.CsvWriter;

public class CsvWriterAppend {
	
public static void main(String[] args) {
		
		String outputFile = "users.csv";
		
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();
			
		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        System.out.println(timestamp);
	        //method 2 - via Date
	        Date date1 = new Date();
	        System.out.println(new Timestamp(date1.getTime()));
	        
	        Date date = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	        String formattedDate = sdf.format(date);
	        System.out.println(formattedDate); // 12/01/2011 4:48:16 PM
	        
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write("id");
				csvOutput.write("name");
				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line
			
			// write out a few records
			csvOutput.write("1");
			csvOutput.write(timestamp.toString());
			csvOutput.write(new Timestamp(date1.getTime()).toString());
			csvOutput.write(formattedDate);
			csvOutput.endRecord();
			
			csvOutput.write("2");
			csvOutput.write("John");
			csvOutput.endRecord();
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
