package nocamelstyle.test.animatedvectordrawableproject

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<ImageView>(R.id.imageView).let { view ->
            (view.drawable as? Animatable)?.let {
                it.start()
            }
        }

        findViewById<ImageView>(R.id.imageView2).let { view ->
//            val vector = VectorChildFinder(this, R.drawable.ic_baseline_battery, view)
//
//            Handler().postDelayed({
//                val path1: VectorDrawableCompat.VFullPath = vector.findPathByName("level_full")
//                path1.fillAlpha = 0f
//                view.invalidate()
//            }, 500)
//
//            Handler().postDelayed({
//                val path1: VectorDrawableCompat.VFullPath = vector.findPathByName("level_normal")
//                path1.fillAlpha = 0f
//                view.invalidate()
//            }, 1000)
//
//            Handler().postDelayed({
//                val path1: VectorDrawableCompat.VFullPath = vector.findPathByName("level_low")
//                path1.fillAlpha = 0f
//                view.invalidate()
//            }, 1500)
//
//            Handler().postDelayed({
//                val path1: VectorDrawableCompat.VFullPath = vector.findPathByName("level_empty")
//                path1.fillAlpha = 0f
//                view.invalidate()
//            }, 2000)



//            val vector = VectorChildFinder(context, R.drawable.drawable_id, imageView)
//            vector.findPathByName("path_name").fillColor = Color.RED

//            (view.drawable as? Animatable)?.let {
//                it.start()
//            }
        }

        var isPlay = true
        val mPlayToPauseAnim = AnimatedVectorDrawableCompat.create(this, R.drawable.play_to_pause);
        val mPauseToPlay = AnimatedVectorDrawableCompat.create(this, R.drawable.pause_to_play);

        findViewById<ImageView>(R.id.imageView3).let { view ->
            view.setOnClickListener { _ ->
                when {
                    isPlay -> {
                        view.setImageDrawable(mPlayToPauseAnim)
                        mPlayToPauseAnim?.start()
                    }
                    else -> {
                        view.setImageDrawable(mPauseToPlay)
                        mPauseToPlay?.start()
                    }
                }
                isPlay = !isPlay
            }
        }

        findViewById<FrameLayout>(R.id.frame).let { layout ->
            val mAnimationDrawable = layout.background as AnimationDrawable
            mAnimationDrawable.setEnterFadeDuration(2500)
            mAnimationDrawable.setExitFadeDuration(5000)
            mAnimationDrawable.start()
        }
    }
}