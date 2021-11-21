package common;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class JsonHelper {

	public void generateJsonFile(Map<String, String> data, String fileName) throws IOException
	{
		JsonObjectBuilder JsonObjectBuilder = Json.createObjectBuilder();
		JsonArrayBuilder JsonObjectBuilderRows = Json.createArrayBuilder();
		
		for (Entry<String, String> job : data.entrySet()){
			JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
			objectBuilder.add("title", job.getKey());
			objectBuilder.add("location", job.getValue());
			JsonObjectBuilderRows.add(objectBuilder);
		}

		JsonObject jsonFile = JsonObjectBuilder.add("Results", JsonObjectBuilderRows).build();
		FileWriter file = new FileWriter(fileName);
		file.write(jsonFile.toString());
		file.flush();
		file.close();
	}
}
