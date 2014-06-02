package org.holoeverywhere.demo.fragments.index;

import org.holoeverywhere.LayoutInflater;
import org.holoeverywhere.app.Fragment;
import org.holoeverywhere.demo.R;
import org.holoeverywhere.demo.fragments.OtherFragment;
import org.holoeverywhere.demo.fragments.about.AboutFragment;
import org.holoeverywhere.demo.fragments.lists.ListsFastScrollWithSectionsFragment;
import org.holoeverywhere.demo.fragments.pickers.PickersFragment;
import org.holoeverywhere.demo.fragments.tabber.TabsTabsSwipeFragment;
import org.holoeverywhere.widget.RadioButton;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class IndexFragment extends Fragment implements OnClickListener {

    private RadioButton mRbNavBtn1, mRbNavBtn2,mRbNavBtn3,mRbNavBtn4,mRbNavBtn5;

    private FragmentManager fManager;
    private FragmentTransaction fTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRbNavBtn1 = (RadioButton) getActivity().findViewById(R.id.rb_nav_btn1);
        mRbNavBtn2 = (RadioButton) getActivity().findViewById(R.id.rb_nav_btn2);
        mRbNavBtn3 = (RadioButton) getActivity().findViewById(R.id.rb_nav_btn3);
        mRbNavBtn4 = (RadioButton) getActivity().findViewById(R.id.rb_nav_btn4);
//        mRbNavBtn5 = (RadioButton) getActivity().findViewById(R.id.rb_nav_btn5);
        mRbNavBtn1.setChecked(true);
        mRbNavBtn1.setOnClickListener(this);
        mRbNavBtn2.setOnClickListener(this);
        mRbNavBtn3.setOnClickListener(this);
        mRbNavBtn4.setOnClickListener(this);
//        mRbNavBtn5.setOnClickListener(this);
        fManager = getChildFragmentManager();
        
        fTransaction = fManager.beginTransaction();
        fTransaction.replace(R.id.layout_container, new OtherFragment());
        fTransaction.commit();

    }

    @Override
    public void onClick(View v) {
        fTransaction = fManager.beginTransaction();
        switch (v.getId()) {
        case R.id.rb_nav_btn1:
            fTransaction.replace(R.id.layout_container, new OtherFragment());
            break;
        case R.id.rb_nav_btn2:
            fTransaction.replace(R.id.layout_container, new TabsTabsSwipeFragment());
            break;
        case R.id.rb_nav_btn3:
            fTransaction.replace(R.id.layout_container, new PickersFragment());
            break;
        case R.id.rb_nav_btn4:
            fTransaction.replace(R.id.layout_container, new ListsFastScrollWithSectionsFragment());
            break;
//        case R.id.rb_nav_btn5:
//            fTransaction.replace(R.id.layout_container, new AboutFragment());
//            break;
        }
        fTransaction.commit();
    }

}
