//http://givemepass.blogspot.tw/2012/07/tabactivity.html

package com.javacodegeeks.android.fragmentstest;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_main);
      
     
	}

	public void selectFrag(View view) {
		 Fragment fr,f2,f3;
			 fr = new FragmentOne();
			 f2 = new FragmentTwo();
			 f3 = new FragmentThree();
		 FragmentManager fm = getFragmentManager();
		 fr = (FragmentOne)fm.findFragmentById(R.id.fragment_place);
		 //firstfragment should display one pie chart
		 
		 f2 = (FragmentTwo)fm.findFragmentById(R.id.fragment_1);
		 //at second fragment's place should display another
		 f3 = (FragmentThree)fm.findFragmentById(R.id.fragment_2);
	     /*
		 FragmentTransaction fragmentTransaction = fm.beginTransaction();
	     fragmentTransaction.replace(R.id.fragment_place, fr);
	     fragmentTransaction.commit();
	     
	     FragmentManager fm2 = getFragmentManager();
	     FragmentTransaction fragmentTransaction2= fm.beginTransaction();
	     fragmentTransaction2.replace(R.id.fragment_1, f2);
	     fragmentTransaction2.commit();
	     */
	     /*
	      *  myPlayerFragment = (PlayerFragment)fragmentManager.findFragmentById(R.id.playerfragment);*/
	}
 
}
