package development.ngbontsi.com.activities;



import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.R;
import development.ngbontsi.com.constants.ApplicationConstants;
import development.ngbontsi.com.fregment.NavigationDrawer;

public class UsersListActivity extends AppCompatActivity {
    private final AppCompatActivity activity = UsersListActivity.this;

    private Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout_fragments);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager_fragments);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),getFragments()));
        tabLayout.setupWithViewPager(viewPager);

    }

    public class MyAdapter extends FragmentStatePagerAdapter{
        private  final List<Fragment> fragments;
        public MyAdapter(FragmentManager fragmentManager, List<Fragment>fragments){
            super(fragmentManager);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments.get(position).getArguments().getCharSequence(ApplicationConstants.Screen.toString());
        }


        private CharSequence getImage(CharSequence screenName){

            if(screenName.toString().equals(ApplicationConstants.All_Events.getValue())){
                return setImage(R.drawable.event);
            }
            if(screenName.toString().equals(ApplicationConstants.Search_Event.getValue())){
                   return setImage(R.drawable.search);
                }
          if(screenName.toString().equals(ApplicationConstants.Notifications.getValue())){
                return setImage(R.drawable.notifications);
            }
            if(screenName.toString().equals(ApplicationConstants.Mails.getValue())){
                return setImage(R.drawable.mails);
            }

            return setImage(R.drawable.com_facebook_button_icon);
        }

        private CharSequence setImage(int logo) {
            SpannableStringBuilder stringBuilder;
            ImageSpan imageSpan;
            drawable = getResources().getDrawable(logo);
            stringBuilder = new SpannableStringBuilder(" ");
            drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
            imageSpan = new ImageSpan(drawable,ImageSpan.ALIGN_BASELINE);
            stringBuilder.setSpan(imageSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            return stringBuilder;
        }
    }

    private List<Fragment> getFragments(){
        final List<Fragment> list = new ArrayList<Fragment>();
        list.add(NavigationDrawer.newInstance(ApplicationConstants.All_Events.getValue()));
        list.add(NavigationDrawer.newInstance(ApplicationConstants.Search_Event.getValue()));
        list.add(NavigationDrawer.newInstance(ApplicationConstants.Notifications.getValue()));
        list.add(NavigationDrawer.newInstance(ApplicationConstants.Mails.toString()));
        return list;
    }

}
