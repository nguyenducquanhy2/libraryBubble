package com.example.librarybuble

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.bubbleshowtooltips.BubbleShowCase
import com.example.bubbleshowtooltips.BubbleShowCaseBuilder
import com.example.bubbleshowtooltips.BubbleShowCaseListener
import com.example.bubbleshowtooltips.BubbleShowCaseSequence
import com.example.librarybuble.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
    }

//    private fun callApi(){
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://ai.amobear.com/aiemailcalendar/") // Replace with your base URL
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val apiService = retrofit.create(ApiService::class.java)
//        CoroutineScope(Dispatchers.IO).launch { // When in a ViewModel
//            try {
////                val requestBody = PostGpt(
////                    messages = listOf(Message("tôi cần bạn việt cho tôi thực đơn trong 1 tuần", "user")),
////                    model = "gpt-3.5-turbo"
////                )
//                val postGPT=PostGpt(model = "gpt-3.5-turbo", mutableListOf(Message(content = "tôi cần bạn việt cho tôi thực đơn trong 1 tuần", role = "user")))
//                val response = apiService.sendRequestMessage(postGPT)
//
//                if (response.isSuccessful) {
//                    // Handle the successful response
//                    val responseBody = response.body()
//                    // Update UI accordingly
//                    Log.e("callApi", "callApi: success" )
//                } else {
//                    // Handle the error response
//                    // Update UI accordingly
//                    Log.e("callApi", "callApi: fail" )
//                }
//            } catch (e: Exception) {
//                // Handle exceptions
//                // Update UI accordingly
//                Log.e("callApi", "callApi: ${e.message.toString()}" )
//            }
//        }
//    }

    private fun setUpListeners(){
        binding.btnShow.setOnClickListener { getSequence().show() }
        getSequence().show()

//        getSequence().show()
//        binding.buttonSimpleShowCase.setOnClickListener { getSimpleShowCaseBuilder().show() }
//        binding.buttonColorShowCase.setOnClickListener { getCustomColorShowCaseBuilder().show() }
//        binding.buttonTextSizeShowCase.setOnClickListener { getTextSizeShowCaseBuilder().show() }
//        binding.buttonArrowLeftShowCase.setOnClickListener { getArrowLeftShowCaseBuilder().show() }
//        binding.buttonArrowRightShowCase.setOnClickListener { getArrowRightShowCaseBuilder().show() }
//        binding.buttonEventListener.setOnClickListener { getListenerShowCaseBuilder().show() }
//        binding.buttonSequence.setOnClickListener { getSequence().show() }
    }

    //SHOW CASES GETTERS
//
//    private fun getSimpleShowCaseBuilder(): BubbleShowCaseBuilder {
//        return BubbleShowCaseBuilder(this)
//            .title("Welcome!!!")
//            .description("This is a simple BubbleShowCase with default values.")
//            .targetView(binding.buttonSimpleShowCase)
//
//    }
//
//    private fun getCustomColorShowCaseBuilder(): BubbleShowCaseBuilder{
//        return BubbleShowCaseBuilder(this)
//            .title("Custom your bubble style!")
//            .description("It is possible to change the text color, background ... and you can even add an image into your bubble.")
//            .backgroundColor(ContextCompat.getColor(this, R.color.colorBlueGray))
//            .image(ContextCompat.getDrawable(this, R.drawable.ic_color)!!)
//            .closeActionImage(ContextCompat.getDrawable(this, R.drawable.ic_close_black)!!)
//            .textColor(ContextCompat.getColor(this, R.color.colorBlack))
//            .targetView(binding.buttonColorShowCase)
//    }
//
//    private fun getTextSizeShowCaseBuilder(): BubbleShowCaseBuilder{
//        return BubbleShowCaseBuilder(this)
//            .title("Change text sizes!")
//            .description("You can also choose the best text size for you.")
//            .backgroundColor(ContextCompat.getColor(this, R.color.colorTeal))
//            .image(ContextCompat.getDrawable(this, R.drawable.ic_format_size)!!)
//            .titleTextSize(18)
//            .descriptionTextSize(16)
//            .closeActionImage(null)
//            .targetView(binding.buttonTextSizeShowCase)
//    }
//
//    private fun getArrowLeftShowCaseBuilder(): BubbleShowCaseBuilder{
//        return BubbleShowCaseBuilder(this)
//            .title("Force the position of the bubble!")
//            .description("You only have to specify in which side you want the arrow, and the bubble will be located depending on it.")
//            .arrowPosition(BubbleShowCase.ArrowPosition.LEFT)
//            .backgroundColor(ContextCompat.getColor(this, R.color.colorRed))
//            .targetView(binding.buttonArrowLeftShowCase)
//    }
//
//    private fun getArrowRightShowCaseBuilder(): BubbleShowCaseBuilder{
//        return BubbleShowCaseBuilder(this)
//            .title("Arrow set on right side this time :)")
//            .arrowPosition(BubbleShowCase.ArrowPosition.RIGHT)
//            .backgroundColor(ContextCompat.getColor(this, R.color.colorPink))
//            .targetView(binding.buttonArrowRightShowCase)
//    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getListenerShowCaseBuilder(message1: String,message2: String, targetView: View): BubbleShowCaseBuilder {
        return BubbleShowCaseBuilder(this)
            .title(message1)
            .description(message2)
            .backgroundColor(ContextCompat.getColor(this, R.color.white))
            .disableCloseAction(true)
            .highlightMode(BubbleShowCase.HighlightMode.VIEW_SURFACE)
            .listener(object : BubbleShowCaseListener {
                override fun onBubbleClick(bubbleShowCase: BubbleShowCase) {
                    bubbleShowCase.dismiss()
//                    Toast.makeText(this@NoteTestBubleActivity, "OnBubbleClick", Toast.LENGTH_SHORT).show()
                }

                override fun onBackgroundDimClick(bubbleShowCase: BubbleShowCase) {
                    bubbleShowCase.dismiss()
//                    Toast.makeText(this@NoteTestBubleActivity, "OnBackgroundDimClick", Toast.LENGTH_SHORT).show()
                }

                override fun onTargetClick(bubbleShowCase: BubbleShowCase) {
                    bubbleShowCase.dismiss()
//                    Toast.makeText(this@NoteTestBubleActivity, "OnTargetClick", Toast.LENGTH_SHORT).show()
                }

                override fun onCloseActionImageClick(bubbleShowCase: BubbleShowCase) {
                    bubbleShowCase.dismiss()
//                    Toast.makeText(this@NoteTestBubleActivity, "OnClose", Toast.LENGTH_SHORT).show()
                }
            })
            .targetView(targetView)

    }

    private fun getSequence(): BubbleShowCaseSequence {
        return BubbleShowCaseSequence().addShowCases(listOf(
            getListenerShowCaseBuilder("Nhấn để thêm mới","",binding.btnAddNoteNormal),
            getListenerShowCaseBuilder("AI Note","( Mới )",binding.btnSwitchChecklist),
            getListenerShowCaseBuilder("Tạo “To do list”","",binding.btnScanText),
            getListenerShowCaseBuilder("Scan note","( Mới )",binding.btnRecord),
        ))
    }
}