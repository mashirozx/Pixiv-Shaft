package ceui.lisa.adapters;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CompoundButton;

import com.bumptech.glide.Glide;

import java.util.List;

import ceui.lisa.R;
import ceui.lisa.databinding.RecyCommentListBinding;
import ceui.lisa.databinding.RecySelectTagBinding;
import ceui.lisa.model.BookmarkTagsBean;
import ceui.lisa.model.CommentsBean;
import ceui.lisa.utils.GlideUtil;

/**
 * 评论列表
 */

public class TAdapter extends BaseAdapter<BookmarkTagsBean, RecySelectTagBinding> {


    public TAdapter(List<BookmarkTagsBean> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_select_tag;
    }

    @Override
    public void bindData(BookmarkTagsBean target, ViewHolder<RecySelectTagBinding> bindView, int position) {
        bindView.baseBind.starSize.setText(allIllust.get(position).getName());
        bindView.baseBind.illustCount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    allIllust.get(position).setSelected(true);
                } else {
                    allIllust.get(position).setSelected(false);
                }
            }
        });
        if (allIllust.get(position).isSelected()) {
            bindView.baseBind.illustCount.setChecked(true);
        } else {
            bindView.baseBind.illustCount.setChecked(false);
        }
        if (mOnItemClickListener != null) {
            bindView.itemView.setOnClickListener(v -> {
                bindView.baseBind.illustCount.performClick();
            });
        }
    }
}
