package br.edu.ifpb.zxing;

//import br.exemplozxingintegration.MainActivity;
//import br.exemplozxingintegration.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public static final int REQUEST_CODE = 0;
	private TextView txResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txResult = (TextView) findViewById(R.id.txResult);
	}

	public void callZXing(View view) {
		Intent intent = new Intent(getApplicationContext(),MainActivity.class);
		intent.setAction("com.google.zxing.client.android.SCAN");
		intent.putExtra("SAVE_HISTORY", false);
		startActivityForResult(intent, 0);
	} 

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
			txResult.setText("RESULTADO: " + data.getStringExtra("SCAN_RESULT")
					+ " (" + data.getStringExtra("SCAN_FORMAT") + ")");
		}
	}
	
/**
	public static final int REQUEST_CODE = 0;
	private TextView txResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		

		txResult = (TextView) findViewById(R.id.txResult);
		
			// start the scanning activity from the
			// com.google.zxing.client.android.SCAN intent
			Intent intent = new Intent("com.google.zxing.client.android.CaptureActivity");
			intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
			startActivityForResult(intent, REQUEST_CODE);
		
	}

	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
			txResult.setText("RESULTADO: " + data.getStringExtra("SCAN_RESULT")
					+ " (" + data.getStringExtra("SCAN_FORMAT") + ")");
		}
	}*/
}
