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

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import it.AleValeProject.Esame2k20.model.SingleMetaData;
import it.AleValeProject.Esame2k20.model.SingleImage;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class DatabaseCreation {

	// Start of user code (user defined attributes for DownloadInformazioni)

	// End of user code
	
	/**
	 * The constructor.
	 */
	public DatabaseCreation() {
		// Start of user code constructor for DownloadInformazioni)
		super();
		// End of user code
	}

	/**
	 * Description of the method RichiestaId.
	 */
	public String[] RequestId() {
		// Start of user code for method RichiestaId
		// End of user code
		BufferedReader reader;
		String support;
		String[] importedId = new String[150];
		try {
			reader = new BufferedReader(new FileReader("IdList.txt"));
			support = reader.readLine();
			importedId= support.split(",");
			
		}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return importedId;
	}

	/**
	 * Description of the method RichiestaInformazioni.
	 */
	public String[] RequestInformation() {
		// Start of user code for method RichiestaInformazioni
		// End of user code
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

				// create a urlconnection object
				URLConnection urlConnection = url.openConnection();

				// wrap the urlconnection in a bufferedreader
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				String line;

				// read from the urlconnection via the bufferedreader
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
	 * Description of the method SalvataggioInformazioni.
	 */
	public ArrayList<SingleRecordInfo> SavingInformation() {
		// Start of user code for method SalvataggioInformazioni
		// End of user code
		String[] toParse=RequestInformation();
		SingleImage imagineSupport;
		ArrayList<SingleRecordInfo> informations = new ArrayList<SingleRecordInfo>();
		for(int i =0;i<toParse.length;i++) {
			SingleRecordInfo  recordSupport = new SingleRecordInfo();
			try {
				JSONObject objectSupport = new JSONObject(toParse[i]);
				JSONArray arraySupport = objectSupport.getJSONArray("data");
		        for (int j = 0; j < arraySupport.length(); j++) {
		        
		        	recordSupport.setIdAutore(arraySupport.getJSONObject(j).getString("author_id"));
		        	recordSupport.setId(arraySupport.getJSONObject(j).getString("id"));
			        recordSupport.setDataCreazione(arraySupport.getJSONObject(j).getString("created_at"));
			        recordSupport.setLinguaggio(arraySupport.getJSONObject(j).getString("lang"));
			        recordSupport.setSorgente(arraySupport.getJSONObject(j).getString("source"));
			        recordSupport.setText(arraySupport.getJSONObject(j).getString("text"));
		        
			        if(toParse[i].contains("hashtags")) {
			        	JSONObject related = arraySupport.getJSONObject(j).getJSONObject("entities");
			        	JSONArray hashtagSupport = related.getJSONArray("hashtags");
			        	for(int k=0;k<hashtagSupport.length();k++)
			        		recordSupport.setHashatg(hashtagSupport.getJSONObject(k).getString("tag"));
			        }
		        }
		        JSONObject objectSupport2 = objectSupport.getJSONObject("includes");
		        JSONArray arraySupport2 = objectSupport2.getJSONArray("media");
		        for(int k=0;k<arraySupport2.length();k++) {
		        	imagineSupport = new SingleImage();
		        	if(toParse[i].contains("\"url\":"))
		        		imagineSupport.setUrl(arraySupport2.getJSONObject(k).getString("url"));
		        	imagineSupport.setAltezza(arraySupport2.getJSONObject(k).getInt("height"));
		        	imagineSupport.setLarghezza(arraySupport2.getJSONObject(k).getInt("width"));
		        	imagineSupport.setMegapixel((double)(arraySupport2.getJSONObject(k).getInt("height")*arraySupport2.getJSONObject(k).getInt("width"))/1000000);
		        	imagineSupport.setIdImmagine(arraySupport2.getJSONObject(k).getString("media_key"));
		        	imagineSupport.setTipo(arraySupport2.getJSONObject(k).getString("type"));
		        	recordSupport.setImmagini(imagineSupport);
		        }
		        
		        informations.add(recordSupport);
			}catch(Exception io)
			{
				i++;
			}
		}
		return informations;
	// Start of user code (user defined methods for DownloadInformazioni)

	// End of user code
	}
}
