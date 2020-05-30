package it.AleValeProject.Esame2k20.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

import it.AleValeProject.Esame2k20.exception.DeleteFileException;
import it.AleValeProject.Esame2k20.model.SingleImage;
import it.AleValeProject.Esame2k20.model.SingleMetadata;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

/**
 * The class that manages the creation of the database with the tweet
 * @author vale&ale
 *
 */
public class DatabaseCreation extends SingleMetadata{

	/**
	 * The function that reads all the id to use to import tweets.
	 * @return an Array of string with the all ids.
	 * @throws DeleteFileException
	 */
	private String[] RequestId() throws DeleteFileException {
		BufferedReader reader;
		String support;
		String[] importedId = new String[150];
		try {
			reader = new BufferedReader(new FileReader("IdList.txt"));
			support = reader.readLine();
			importedId= support.split(",");
			
		}catch (FileNotFoundException e1) {
			throw new DeleteFileException("File \"IdList.txt\" not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return importedId;
	}

	/**
	 * The function that open the connection with the twitter API and reads all thw information about the tweets
	 * @return an Array of string which contains all the tweets downloaded from Twitter
	 * @throws DeleteFileException
	 */
	private String[] RequestInformation() throws DeleteFileException {
		String[] id =RequestId();
		String[] info = new String[150];
		int number=0;
		for (int i = 0; i < id.length; i++) {
			StringBuilder content = new StringBuilder();

			// many of these calls can throw exceptions, so i've just
			// wrapped them all in one try/catch statement.
			try {
				// create a url object
				URL url = new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/labs/2/tweets?ids="+id[i]+ "&expansions=attachments.media_keys&tweet.fields=attachments,author_id,created_at,geo,id,lang,source,public_metrics,text,entities&media.fields=duration_ms,height,media_key,non_public_metrics,preview_image_url,public_metrics,type,url,width&user.fields=location");

				// create a url connection object
				URLConnection urlConnection = url.openConnection();

				// wrap the url connection in a bufferedreader
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				String line;

				// read from the url connection via the bufferedreader
				while ((line = bufferedReader.readLine()) != null) {
					content.append(line + "\n");
				}
				bufferedReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			info[i]=content.toString();

		}
		
		while(info[number]!=null) {
			number++;
		}
			    // return a one bigger
		return Arrays.copyOf(info, number);
	}
	
	
	/**
	 * The function that saving the information of which tweet in a record
	 * @return An ArrayList with the all record read -> the database
	 * @throws DeleteFileException
	 */
	public ArrayList<SingleRecordInfo> SavingInformation() throws DeleteFileException {
		String[] toParse=RequestInformation();
		SingleImage imagineSupport;
		ArrayList<SingleRecordInfo> informations = new ArrayList<SingleRecordInfo>();
		for(int i =0;i<toParse.length;i++) {
			SingleRecordInfo  recordSupport = new SingleRecordInfo();
			try {
				JSONObject objectSupport = new JSONObject(toParse[i]);
				JSONArray arraySupport = objectSupport.getJSONArray("data");
		        for (int j = 0; j < arraySupport.length(); j++) {
		        
		        	recordSupport.setIdAuthor(arraySupport.getJSONObject(j).getString("author_id"));
		        	recordSupport.setId(arraySupport.getJSONObject(j).getString("id"));
			        recordSupport.setDataCreation(arraySupport.getJSONObject(j).getString("created_at"));
			        recordSupport.setLanguage(arraySupport.getJSONObject(j).getString("lang"));
			        recordSupport.setSource(arraySupport.getJSONObject(j).getString("source"));
			        recordSupport.setText(arraySupport.getJSONObject(j).getString("text"));
		        
			        if(toParse[i].contains("hashtags")) {
			        	JSONObject related = arraySupport.getJSONObject(j).getJSONObject("entities");
			        	JSONArray hashtagSupport = related.getJSONArray("hashtags");
			        	for(int k=0;k<hashtagSupport.length();k++)
			        		recordSupport.setHashtag(hashtagSupport.getJSONObject(k).getString("tag"));
			        }
		        }
		        JSONObject objectSupport2 = objectSupport.getJSONObject("includes");
		        JSONArray arraySupport2 = objectSupport2.getJSONArray("media");
		        for(int k=0;k<arraySupport2.length();k++) {
		        	imagineSupport = new SingleImage();
		        	if(toParse[i].contains("\"url\":"))
		        		imagineSupport.setUrl(arraySupport2.getJSONObject(k).getString("url"));
		        	imagineSupport.SetHeight(arraySupport2.getJSONObject(k).getInt("height"));
		        	imagineSupport.setWidth(arraySupport2.getJSONObject(k).getInt("width"));
		        	imagineSupport.setMegapixel((double)(arraySupport2.getJSONObject(k).getInt("height")*arraySupport2.getJSONObject(k).getInt("width"))/1000000);
		        	imagineSupport.setIdImage(arraySupport2.getJSONObject(k).getString("media_key"));
		        	imagineSupport.setType(arraySupport2.getJSONObject(k).getString("type"));
		        	recordSupport.setImages(imagineSupport);
		        }
		        
		        informations.add(recordSupport);
			}catch(Exception io)
			{
				i++;
			}
		}
		return informations;
	}
}
