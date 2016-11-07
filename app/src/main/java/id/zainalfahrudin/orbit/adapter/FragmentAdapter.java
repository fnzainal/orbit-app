package id.zainalfahrudin.orbit.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import id.zainalfahrudin.orbit.R;
import id.zainalfahrudin.orbit.fragment.Fragment1;
import id.zainalfahrudin.orbit.fragment.Fragment2;
import id.zainalfahrudin.orbit.fragment.Fragment3;

/**
 * Created by zainal on 10/11/16.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    String[] title = new String[]{"TAB1","TAB2","TAB2"};


    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment tab = null;
        switch (position){
            case 0:
                tab = new Fragment1();
                break;
            case 1:
                tab = new Fragment2();
                break;
            case 2:
                tab = new Fragment3();
                break;
        }
        return tab;
    }
}
