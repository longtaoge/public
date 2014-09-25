package com.ac.angelcrunch;

import android.app.Application;
import android.content.Context;
import android.view.Display;

public class MyApplication extends Application {

	private static MyApplication instance = null;
	private static Context context = null;

	private float mDensity;

	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();
		instance = this;

		setmDensity(getResources().getDisplayMetrics().density);

	}

	public static Context getAppContext() {
		return context;
	}

	public static MyApplication getInstance() {
		if (null == instance) {
			synchronized (MyApplication.class) {
				instance = new MyApplication();
			}
		}

		return instance;
	}

	public float getmDensity() {
		return mDensity;
	}

	public void setmDensity(float mDensity) {
		this.mDensity = mDensity;
	}

}
