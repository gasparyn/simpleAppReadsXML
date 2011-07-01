package gaspar.test;

import java.io.IOException;
import us.monoid.web.Resty;
import us.monoid.web.XMLResource;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
/**
 * This android app fetches data from the heroku server of our Vogueable app
 * and displays the output as xml to the screen
 * 
 * 
 * @author gaspar obimba
 *
 */
public class MainActivity extends Activity {
	
	
	String id = "",name="";
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView tv = (TextView) findViewById(R.id.text_field);

		Resty r = new Resty();
		XMLResource usr1 = null;
		
		/* this try catch block prints out all the items in our server as xml
		 * we can then parse the xml generated and extract item attributes as required.
		 * As of now, this simple implementation
		 */
		try {
			usr1 = r.xml("http://vogueable.heroku.com/items.xml");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("gaspar", "exception on r.xml");
		}
		tv.setText(""+usr1);//allow the xml to be displayed on the screen
		
		/*------------------------------*/
		//ASIN id
		try {
			id = usr1.get("/item/Asin/text()", String.class);
		} catch (Exception e) {
			Log.e("gaspar", "exception on get");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//tv.setText(id);
		
	}

}
