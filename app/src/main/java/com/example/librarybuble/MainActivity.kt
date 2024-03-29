package com.example.librarybuble

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var buttonSimpleShowCase: AppCompatButton
    private lateinit var buttonColorShowCase: AppCompatButton
    private lateinit var buttonTextSizeShowCase: AppCompatButton
    private lateinit var buttonArrowLeftShowCase: AppCompatButton
    private lateinit var buttonArrowRightShowCase: AppCompatButton
    private lateinit var buttonEventListener: AppCompatButton
    private lateinit var buttonEventListener1: AppCompatButton
    private lateinit var buttonEventListener2: AppCompatButton
    private lateinit var buttonEventListener3: AppCompatButton
    private lateinit var buttonSequence: AppCompatButton
    private lateinit var layoutRoot: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mappingView()
        setUpListeners()
    }

    private fun mappingView() {
        buttonSimpleShowCase=findViewById(R.id.buttonSimpleShowCase)
        buttonColorShowCase=findViewById(R.id.buttonColorShowCase)
        buttonTextSizeShowCase=findViewById(R.id.buttonTextSizeShowCase)
        buttonArrowLeftShowCase=findViewById(R.id.buttonArrowLeftShowCase)
        buttonArrowRightShowCase=findViewById(R.id.buttonArrowRightShowCase)
        buttonEventListener=findViewById(R.id.buttonEventListener)
        buttonEventListener1=findViewById(R.id.buttonEventListener1)
        buttonEventListener2=findViewById(R.id.buttonEventListener2)
        buttonEventListener3=findViewById(R.id.buttonEventListener3)
        buttonSequence=findViewById(R.id.buttonSequence)
        layoutRoot=findViewById(R.id.layoutRoot)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setUpListeners(){
//        getSequence().show()
        buttonSimpleShowCase.setOnClickListener { getSimpleShowCaseBuilder().show() }
        buttonColorShowCase.setOnClickListener { getCustomColorShowCaseBuilder().show() }
        buttonTextSizeShowCase.setOnClickListener { getTextSizeShowCaseBuilder().show() }
        buttonArrowLeftShowCase.setOnClickListener { getArrowLeftShowCaseBuilder().show() }
        buttonArrowRightShowCase.setOnClickListener { getArrowRightShowCaseBuilder().show() }
        buttonEventListener.setOnClickListener { getListenerShowCaseBuilder().show() }
        buttonEventListener1.setOnClickListener { getListenerShowCaseBuilder1().show() }
        buttonEventListener2.setOnClickListener { getListenerShowCaseBuilder2().show() }
        buttonEventListener3.setOnClickListener { getListenerShowCaseBuilder3().show() }
        buttonSequence.setOnClickListener { getSequence().show() }

        layoutRoot.setOnTouchListener { v, event ->
            Log.e("toaDoManHinh", "x: ${event.x}" )
            Log.e("toaDoManHinh", "y: ${event.y}" )
            true
        }

    }

    private fun getSimpleShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
            .title("Ai Note")
            .description("( Mới )")
            .backgroundColor(ContextCompat.getColor(this,R.color.white))
            .textColor(ContextCompat.getColor(this,R.color.black))
            .targetView(buttonSimpleShowCase)
            .listener(object : BubbleShowCaseListener {
                override fun onBubbleClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnBubbleClick", Toast.LENGTH_SHORT).show()
                }

                override fun onBackgroundDimClick(bubbleShowCase: BubbleShowCase) {
                    bubbleShowCase.dismiss()
                    Toast.makeText(this@MainActivity, "OnBackgroundDimClick", Toast.LENGTH_SHORT).show()
                }

                override fun onTargetClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnTargetClick", Toast.LENGTH_SHORT).show()
                }

                override fun onCloseActionImageClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnClose", Toast.LENGTH_SHORT).show()
                }
            })
            .disableCloseAction(true)

    }

    private fun getCustomColorShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
            .title("Ai Note")
            .description("( Mới )")
            .backgroundColor(ContextCompat.getColor(this, R.color.colorBlueGray))
            .closeActionImage(ContextCompat.getDrawable(this, R.drawable.ic_close)!!)

            .textColor(ContextCompat.getColor(this,R.color.white)).targetView(buttonColorShowCase)
    }

    private fun getTextSizeShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
            .title("Ai Note")
            .description("( Mới )")
            .backgroundColor(ContextCompat.getColor(this, R.color.colorTeal))


            .textColor(ContextCompat.getColor(this,R.color.white)).titleTextSize(18)
            .descriptionTextSize(16)
            .closeActionImage(null)
            .targetView(buttonTextSizeShowCase)
    }

    private fun getArrowLeftShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
            .title("Ai Note")
            .description("( Mới )")
            .arrowPosition(BubbleShowCase.ArrowPosition.LEFT)

            .textColor(ContextCompat.getColor(this,R.color.white)).backgroundColor(ContextCompat.getColor(this, R.color.colorRed))
            .targetView(buttonArrowLeftShowCase)
    }

    private fun getArrowRightShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
            .title("Ai Note")
            .description("( Mới )")
            .arrowPosition(BubbleShowCase.ArrowPosition.RIGHT)

            .textColor(ContextCompat.getColor(this,R.color.white)).backgroundColor(ContextCompat.getColor(this, R.color.colorPink))
            .targetView(buttonArrowRightShowCase)
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getListenerShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
            .title("Ai Note")
            .description("( Mới )")
            .backgroundColor(ContextCompat.getColor(this, R.color.black))
            .arrowPosition(BubbleShowCase.ArrowPosition.BOTTOM)

            .textColor(ContextCompat.getColor(this,R.color.white))
//            .closeActionImage(getDrawable(R.drawable.flag_id))
            .disableCloseAction(true)
            .listener(object : BubbleShowCaseListener {
                override fun onBubbleClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnBubbleClick", Toast.LENGTH_SHORT).show()
                }

                override fun onBackgroundDimClick(bubbleShowCase: BubbleShowCase) {
                    bubbleShowCase.dismiss()
                    Toast.makeText(this@MainActivity, "OnBackgroundDimClick", Toast.LENGTH_SHORT).show()
                }

                override fun onTargetClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnTargetClick", Toast.LENGTH_SHORT).show()
                }

                override fun onCloseActionImageClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnClose", Toast.LENGTH_SHORT).show()
                }
            })
            .targetView(buttonEventListener)

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getListenerShowCaseBuilder2(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
            .title("Ai Note")
            .description("( Mới )")
            .backgroundColor(ContextCompat.getColor(this, R.color.black))
            .arrowPosition(BubbleShowCase.ArrowPosition.BOTTOM)

            .textColor(ContextCompat.getColor(this,R.color.white))
//            .closeActionImage(getDrawable(R.drawable.flag_id))
            .disableCloseAction(true)
            .listener(object : BubbleShowCaseListener {
                override fun onBubbleClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnBubbleClick", Toast.LENGTH_SHORT).show()
                }

                override fun onBackgroundDimClick(bubbleShowCase: BubbleShowCase) {
                    bubbleShowCase.dismiss()
                    Toast.makeText(this@MainActivity, "OnBackgroundDimClick", Toast.LENGTH_SHORT).show()
                }

                override fun onTargetClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnTargetClick", Toast.LENGTH_SHORT).show()
                }

                override fun onCloseActionImageClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnClose", Toast.LENGTH_SHORT).show()
                }
            })
            .targetView(buttonEventListener2)

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getListenerShowCaseBuilder1(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
            .title("Ai Note")
            .description("( Mới )")
            .backgroundColor(ContextCompat.getColor(this, R.color.black))
            .arrowPosition(BubbleShowCase.ArrowPosition.BOTTOM)

            .textColor(ContextCompat.getColor(this,R.color.white))
//            .closeActionImage(getDrawable(R.drawable.flag_id))
            .disableCloseAction(true)
            .listener(object : BubbleShowCaseListener {
                override fun onBubbleClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnBubbleClick", Toast.LENGTH_SHORT).show()
                }

                override fun onBackgroundDimClick(bubbleShowCase: BubbleShowCase) {
                    bubbleShowCase.dismiss()
                    Toast.makeText(this@MainActivity, "OnBackgroundDimClick", Toast.LENGTH_SHORT).show()
                }

                override fun onTargetClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnTargetClick", Toast.LENGTH_SHORT).show()
                }

                override fun onCloseActionImageClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnClose", Toast.LENGTH_SHORT).show()
                }
            })
            .targetView(buttonEventListener1)

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getListenerShowCaseBuilder3(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
            .title("Ai Note")
            .description("( Mới )quanhy200123456789")
            .backgroundColor(ContextCompat.getColor(this, R.color.black))
            .arrowPosition(BubbleShowCase.ArrowPosition.BOTTOM)

            .textColor(ContextCompat.getColor(this,R.color.white))
//            .closeActionImage(getDrawable(R.drawable.flag_id))
            .disableCloseAction(true)
            .listener(object : BubbleShowCaseListener {
                override fun onBubbleClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnBubbleClick", Toast.LENGTH_SHORT).show()
                }

                override fun onBackgroundDimClick(bubbleShowCase: BubbleShowCase) {
                    bubbleShowCase.dismiss()
                    Toast.makeText(this@MainActivity, "OnBackgroundDimClick", Toast.LENGTH_SHORT).show()
                }

                override fun onTargetClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnTargetClick", Toast.LENGTH_SHORT).show()
                }

                override fun onCloseActionImageClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnClose", Toast.LENGTH_SHORT).show()
                }
            })
            .targetView(buttonEventListener3)

    }

    private fun getSequence(): BubbleShowCaseSequence {
        return BubbleShowCaseSequence().addShowCases(listOf(
            getArrowRightShowCaseBuilder(),
            getListenerShowCaseBuilder(),
            getListenerShowCaseBuilder1(),
            getListenerShowCaseBuilder2(),
            getSimpleShowCaseBuilder(),
            getCustomColorShowCaseBuilder(),
            getTextSizeShowCaseBuilder(),
            getArrowLeftShowCaseBuilder(),

            ))
    }
}