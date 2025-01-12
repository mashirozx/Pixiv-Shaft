package ceui.lisa.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ToxicBakery.viewpager.transforms.DrawerTransformer;

import java.util.ArrayList;
import java.util.List;

import ceui.lisa.R;
import ceui.lisa.fragments.FragmentSingleIllust;
import ceui.lisa.model.IllustsBean;
import ceui.lisa.utils.IllustChannel;

public class ViewPagerActivity extends BaseActivity {

    private List<IllustsBean> mIllusts = new ArrayList<>();

    @Override
    protected void initLayout() {
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        mLayoutID = R.layout.activity_view_pager;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        mIllusts.addAll(IllustChannel.get().getIllustList());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setPageTransformer(true, new DrawerTransformer());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return FragmentSingleIllust.newInstance(mIllusts.get(i));
            }

            @Override
            public int getCount() {
                return mIllusts.size();
            }
        });
        int position = getIntent().getIntExtra("position", 0);
        viewPager.setCurrentItem(position);
    }

    @Override
    protected void initData() {

    }
}
