package com.ac.angelcrunch.ui;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.MenuDrawer.OnDrawerStateChangeListener;
import net.simonvt.menudrawer.MenuDrawer.OnInterceptMoveEventListener;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.TextView;

import com.ac.angelcrunch.R;
import com.ac.angelcrunch.fragments.LeftMenuFragment;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.angelcrunch.sdk.utils.LogUtil;

public class MainActivity extends SherlockFragmentActivity {

	private String TAG = "MainActivity";
	private MenuDrawer mDrawer;
	private LeftMenuFragment lmf;

	private ActionBar actionbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		LogUtil.d(TAG, this.getClass().getSimpleName()
				+ " onCreate() invoked!!");
		// Debug.startMethodTracing("MyActivityTrace");
		super.onCreate(savedInstanceState);
		actionbar = getSupportActionBar();
		// actionbar.setHomeButtonEnabled(false);
		actionbar.setDisplayShowHomeEnabled(true);

		actionbar.setTitle("动态");
		actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3f5185")));
		actionbar.setIcon(R.drawable.notification);
		mDrawer = MenuDrawer.attach(this);

		attachLeftMenu();
		Button contentView = new Button(this);
		contentView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(actionbar.isShowing()){
					actionbar.hide();
				}else{
					actionbar.show();
				}
				
			}
		});
		contentView
				.setText("天使汇主窗口，动态、项目列表、投资人列表");
		contentView.setGravity(Gravity.CENTER);
		mDrawer.setContentView(contentView);

		// The drawable that replaces the up indicator in the action bar
		mDrawer.setSlideDrawable(R.drawable.ic_drawer);
		// Whether the previous drawable should be shown
		mDrawer.setOnDrawerStateChangeListener(new OnDrawerStateChangeListener() {

			@Override
			public void onDrawerStateChange(int oldState, int newState) {
				// TODO Auto-generated method stub
				System.out.println("oldState=" + oldState);
				System.out.println("newState=" + newState);
				if (newState != 0) {
					actionbar.setTitle("天使汇");
				} else {
					actionbar.setTitle("动态");
				}
			}

			@Override
			public void onDrawerSlide(float openRatio, int offsetPixels) {
				// TODO Auto-generated method stub
				// System.out.println(openRatio);
			}
		});
		mDrawer.setOnInterceptMoveEventListener(new OnInterceptMoveEventListener() {

			@Override
			public boolean isViewDraggable(View v, int delta, int x, int y) {
				// TODO Auto-generated method stub
				if (x > 0) {
					actionbar.setTitle("天使汇");
				} else {
					actionbar.setTitle("动态");
				}

				return false;
			}
		});

	}

	/**
	 * add menu
	 */
	public void attachLeftMenu() {
		// TextView menuView = new TextView(this);
		// menuView.setTextColor(0xFFFFFFFF);
		// menuView.setText("As the drawer opens, the drawer indicator icon becomes smaller.");
		// menuView.setGravity(Gravity.CENTER);
		mDrawer.setDrawerIndicatorEnabled(true);// 是否显示左上角指示器
		mDrawer.setMenuView(R.layout.activity_left_menu);
		mDrawer.setDropShadowEnabled(false);

		lmf = new LeftMenuFragment();
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		fragmentTransaction.add(R.id.left_menu, lmf);
		fragmentTransaction.commit();
	}

	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("动态").setIcon(R.drawable.ic_refresh).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		menu.add("消息").setIcon(R.drawable.ic_compose).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		menu.add("查找").setIcon(R.drawable.ic_search).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			mDrawer.toggleMenu();
			break;
		}

		return super.onOptionsItemSelected(item);
	}

}
