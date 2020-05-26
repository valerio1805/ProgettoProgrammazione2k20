package it.AleValeProject.Esame2k20.creazioneDatabase;

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

import it.AleValeProject.Esame2k20.model.CampoMetaD;
import it.AleValeProject.Esame2k20.model.Immagine;
import it.AleValeProject.Esame2k20.model.RecordInfo;

public class DownloadInformazioni {

	// Start of user code (user defined attributes for DownloadInformazioni)

	// End of user code
	
	/**
	 * The constructor.
	 */
	public DownloadInformazioni() {
		// Start of user code constructor for DownloadInformazioni)
		super();
		// End of user code
	}

	/**
	 * Description of the method RichiestaId.
	 */
	public String[] RichiestaId() {
		// Start of user code for method RichiestaId
		// End of user code
		BufferedReader lettore;
		String app;
		String[] idImportati = new String[150];
		try {
			lettore = new BufferedReader(new FileReader("IdList.txt"));
			app = lettore.readLine();
			idImportati= app.split(",");
			
		}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idImportati;
	}

	/**
	 * Description of the method RichiestaInformazioni.
	 */
	public String[] RichiestaInformazioni() {
		// Start of user code for method RichiestaInformazioni
		// End of user code
		String[] id =RichiestaId();
		String[] info = new String[150];
		int ne=0;
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
		
		while(info[ne]!=null) {
			ne++;
		}
			    // make a one bigger
		String[] eff = Arrays.copyOf(info, ne);
		return eff;
	}
	
	
	/**
	 * Description of the method SalvataggioInformazioni.
	 */
	public ArrayList<RecordInfo> SalvataggioInformazioni() {
		// Start of user code for method SalvataggioInformazioni
		// End of user code
		String[] daParsare=RichiestaInformazioni();
		Immagine imm;
		ArrayList<RecordInfo> informazioni = new ArrayList<RecordInfo>();
		for(int i =0;i<daParsare.length;i++) {
			RecordInfo  x = new RecordInfo();
			try {
				JSONObject obj = new JSONObject(daParsare[i]);
				JSONArray arr = obj.getJSONArray("data");
		        for (int j = 0; j < arr.length(); j++) {
		        
			        String idAuto = arr.getJSONObject(j).getString("author_id");
			        x.setIdAutore(Double.parseDouble(idAuto));
			        String id = arr.getJSONObject(j).getString("id");
			        x.setId(Double.parseDouble(idAuto));
			        x.setDataCreazione(arr.getJSONObject(j).getString("created_at"));
			        x.setLinguaggio(arr.getJSONObject(j).getString("lang"));
			        x.setSorgente(arr.getJSONObject(j).getString("source"));
			        x.setText(arr.getJSONObject(j).getString("text"));
		        
			        if(daParsare[i].contains("hashtags")) {
			        	JSONObject related = arr.getJSONObject(j).getJSONObject("entities");
			        	JSONArray hash = related.getJSONArray("hashtags");
			        	for(int f=0;f<hash.length();f++)
			        		x.setHashatg(hash.getJSONObject(f).getString("tag"));
			        }
		        }
		        JSONObject ob2 = obj.getJSONObject("includes");
		        JSONArray array2 = ob2.getJSONArray("media");
		        for(int k=0;k<array2.length();k++) {
		        	imm = new Immagine();
		        	if(daParsare[i].contains("\"url\":"))
		        		imm.setUrl(array2.getJSONObject(k).getString("url"));
		        	imm.setAltezza(array2.getJSONObject(k).getInt("height"));
		        	imm.setLarghezza(array2.getJSONObject(k).getInt("width"));
		        	imm.setMegapixel((double)(array2.getJSONObject(k).getInt("height")*array2.getJSONObject(k).getInt("width"))/1000000);
		        	imm.setIdImmagine(array2.getJSONObject(k).getString("media_key"));
		        	imm.setTipo(array2.getJSONObject(k).getString("type"));
		        	x.setImmagini(imm);
		        }
		        
		        informazioni.add(x);
			}catch(Exception io)
			{
				i++;
			}
		}
		return informazioni;
	// Start of user code (user defined methods for DownloadInformazioni)

	// End of user code
	}
}
