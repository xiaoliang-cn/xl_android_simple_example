package com.xiaoliang.xlandroidsimpleexample.animation

import android.os.Bundle
import android.transition.Transition
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.xiaoliang.xlandroidsimpleexample.R
import kotlinx.android.synthetic.main.activity_animation_item_details.*

class AnimationItemDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_item_details)


        // BEGIN_INCLUDE(detail_set_view_name)
        /*
         * Set the name of the view's which will be transition to, using the static values above.
         * This could be done in the layout XML, but exposing it via static variables allows easy
         * querying from other Activities
         */

        // BEGIN_INCLUDE(detail_set_view_name)
        /*
         * Set the name of the view's which will be transition to, using the static values above.
         * This could be done in the layout XML, but exposing it via static variables allows easy
         * querying from other Activities
         */
        //过渡效果
        ViewCompat.setTransitionName(
            transition_Image_View,
            //这个值不能缺少，对应跳转的tag
            VIEW_NAME_HEADER_IMAGE
        )
        ViewCompat.setTransitionName(
            transition_title,
            VIEW_NAME_HEADER_TITLE
        )

        loadItem()
    }

    private fun loadItem() {
        val id = intent.getIntExtra(AnimationItemDetailsActivity.EXTRA_PARAM_ID, 1)
        val at = getItem(id)
        transition_title.text = at?.title
        if (addTransitionListener()) {
            Glide.with(this).load(at!!.image).into(transition_Image_View)
        }
    }

    companion object {
        // Extra name for the ID parameter
        const val EXTRA_PARAM_ID = "detail:_id"

        // View name of the header image. Used for activity scene transitions
        const val VIEW_NAME_HEADER_IMAGE = "detail:header:image"

        // View name of the header title. Used for activity scene transitions
        const val VIEW_NAME_HEADER_TITLE = "detail:header:title"
    }

    fun loadFullSizeImage() {

    }

    /**
     * Try and add a [Transition.TransitionListener] to the entering shared element
     * [Transition]. We do this so that we can load the full-size image after the transition
     * has completed.
     *
     * @return true if we were successful in adding a listener to the enter transition
     */
    @RequiresApi(21)
    //监听过渡生命周期
    private fun addTransitionListener(): Boolean {
        val transition = window.sharedElementEnterTransition
        if (transition != null) {
            // There is an entering shared element transition so add a listener to it
            transition.addListener(object : Transition.TransitionListener {
                override fun onTransitionEnd(transition: Transition) {
                    // As the transition has ended, we can now load the full-size image
                    loadFullSizeImage()

                    // Make sure we remove ourselves as a listener
                    transition.removeListener(this)
                }

                override fun onTransitionStart(transition: Transition) {
                    // No-op
                }

                override fun onTransitionCancel(transition: Transition) {
                    // Make sure we remove ourselves as a listener
                    transition.removeListener(this)
                }

                override fun onTransitionPause(transition: Transition) {
                    // No-op
                }

                override fun onTransitionResume(transition: Transition) {
                    // No-op
                }
            })
            return true
        }

        // If we reach here then we have not added a listener
        return false
    }

}