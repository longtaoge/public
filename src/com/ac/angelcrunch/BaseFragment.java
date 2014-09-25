package com.ac.angelcrunch;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angelcrunch.sdk.imageloader.core.DisplayImageOptions;
import com.angelcrunch.sdk.imageloader.core.ImageLoader;
import com.angelcrunch.sdk.utils.LogUtil;

public  class BaseFragment extends Fragment {

	private final static String TAG = "BaseFragment";

	
 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// LogUtil.d(TAG, "onCreate");

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// LogUtil.d(TAG, "onCreateView");
		View view = inflater.inflate(null, container, false);
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// LogUtil.d(TAG, "onAttach");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		LogUtil.d(TAG, "onActivityCreated");
	}

	@Override
	public void onStart() {
		super.onStart();
		LogUtil.d(TAG, "onStart");
	}

	@Override
	public void onResume() {
		super.onResume();

		LogUtil.d(TAG, "onResume");

	}

	@Override
	public void onPause() {
		super.onPause();
		LogUtil.d(TAG, "onPause");

	}

	@Override
	public void onStop() {
		super.onStop();
		LogUtil.d(TAG, "onStop");
		// getBus().unregister(this);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		LogUtil.d(TAG, "onDestroyView");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		LogUtil.d(TAG, "onDestroy");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		LogUtil.d(TAG, "onDetach");
	}

}
