package com.xiaoliang.xlandroidsimpleexample.animation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.bumptech.glide.Glide
import com.xiaoliang.xlandroidsimpleexample.R
import kotlinx.android.synthetic.main.activity_animation_list.*


//类似与hero动画效果 过渡
class AnimationListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_list)
        main_list_activity_grid.onItemClickListener = mItemOnClickListener
        main_list_activity_grid.adapter = GridAdapter()
    }

    //item 监听器
    private val mItemOnClickListener =
        AdapterView.OnItemClickListener { parent, view, position, id ->
            val at = parent.getItemAtPosition(position) as AnimationItem
            val intent1 = Intent(this, AnimationItemDetailsActivity::class.java)
            intent1.putExtra(AnimationItemDetailsActivity.EXTRA_PARAM_ID, at.id)

            val p1 = androidx.core.util.Pair<View, String>(
                /**
                 * view 是共享元素。即是grid中的元素
                 * 不是跳转之后activity的元素
                 * 不然会报共享元素为null的错误
                 */
                view.findViewById(R.id.imageview_item),
                AnimationItemDetailsActivity.VIEW_NAME_HEADER_IMAGE
            )
            val p2 = androidx.core.util.Pair<View, String>(
                view.findViewById(R.id.textview_title),
                AnimationItemDetailsActivity.VIEW_NAME_HEADER_TITLE
            )

            val l = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, p1, p2
            )
            Log.d("abc1111", l.toString())
            ActivityCompat.startActivity(this, intent1, l.toBundle())

        }


    /**
     * [android.widget.BaseAdapter] which displays items.
     */
    private class GridAdapter : BaseAdapter() {
        override fun getCount(): Int {
            return ITEMS.size
        }

        override fun getItem(position: Int): AnimationItem {
            return ITEMS[position]
        }

        override fun getItemId(position: Int): Long {
            return ITEMS[position].id.toLong()
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
            var mView = view
            if (mView == null) {
                mView = LayoutInflater.from(viewGroup.context).inflate(
                    R.layout.grid_item,
                    viewGroup,
                    false
                )
            }
            val item: AnimationItem = getItem(position)
            // Load the thumbnail image
            val image = mView!!.findViewById<ImageView>(R.id.imageview_item)
            Glide.with(image.context).load(item.image).into(image)
            // Set the TextView's contents
            val name = mView.findViewById<TextView>(R.id.textview_name)
            name?.text = item.title
            return mView
        }
    }

}