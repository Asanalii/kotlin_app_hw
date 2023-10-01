package kz.just_code.helloapp1

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kz.just_code.helloapp1.databinding.ActivityMainBinding
import kz.just_code.helloapp1.ui.theme.HelloApp1Theme

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    private var seconds: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e(this.javaClass.name,">>> onCreate")

        with(binding){
            pauseButton.setOnClickListener{
                pauseClick()
            }
            startButton.setOnClickListener{
                startClick()
            }
            resetButton.setOnClickListener{
                resetClick()
            }
        }
        runTimer()
    }

    private fun runTimer() {
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                val minutes = (seconds % 3600) / 60
                val time = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
                binding.timeView.text = time

                if (running) seconds++
                handler.postDelayed(this, 1000)
            }
        })
    }

    private fun pauseClick(){
        Toast.makeText(this,"Pause",Toast.LENGTH_SHORT).show()
    }
    private fun startClick(){
        Toast.makeText(this,"Start",Toast.LENGTH_SHORT).show()
    }
    private fun resetClick(){
        Toast.makeText(this,"Reset",Toast.LENGTH_SHORT).show()
    }



}
