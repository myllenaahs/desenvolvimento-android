package br.edu.ifpb.accelerometer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	private TextView textViewX;
	private TextView textViewY;
	private TextView textViewZ;
	private TextView textViewDetail;

	private SensorManager mSensorManager;
	private Sensor mAccelerometer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textViewX = (TextView) findViewById(R.id.text_view_x);
		textViewY = (TextView) findViewById(R.id.text_view_y);
		textViewZ = (TextView) findViewById(R.id.text_view_z);
		textViewDetail = (TextView) findViewById(R.id.text_view_detail);

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

	}

	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mAccelerometer,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		Float x = event.values[0];
		Float y = event.values[1];
		Float z = event.values[2];

		textViewX.setText("Posi��o X: " + x.intValue() + " Float: " + x);
		textViewY.setText("Posi��o Y: " + y.intValue() + " Float: " + y);
		textViewZ.setText("Posi��o Z: " + z.intValue() + " Float: " + z);

		if (y < 0) { // O dispositivo esta de cabe�a pra baixo
			if (x > 0)
				textViewDetail
						.setText("Virando para ESQUERDA ficando INVERTIDO");
			if (x < 0)
				textViewDetail
						.setText("Virando para DIREITA ficando INVERTIDO");
		} else {
			if (x > 0)
				textViewDetail.setText("Virando para ESQUERDA ");
			if (x < 0)
				textViewDetail.setText("Virando para DIREITA ");
		}
	}
}
