package umang.slidemenudemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;

import com.actionbarsherlock.view.Menu;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
	
	protected ListFragment mFrag;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
				
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
			mFrag = new SampleListFragment();
			t.replace(R.id.menu_frame, mFrag);
			t.commit();
		} else {
			mFrag = (ListFragment)this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
		}

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		//sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		setSlidingActionBarEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
