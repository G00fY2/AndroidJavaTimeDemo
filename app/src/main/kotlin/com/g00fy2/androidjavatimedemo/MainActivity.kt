package com.g00fy2.androidjavatimedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.g00fy2.androidjavatimedemo.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.joda.time.DateTimeZone
import org.joda.time.format.DateTimeFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            startCountDown().collect {
                binding.countdownTickerTextview.text = it.countdownTick.toString()

                binding.countdownNowLocalTextview.text = DateTimeFormat.longDateTime().print(it.currentTime.withZone(DateTimeZone.getDefault()))
                binding.countdownNowTextview.text = DateTimeFormat.longDateTime().print(it.currentTime)
                binding.countdownEndTextview.text = DateTimeFormat.longDateTime().print(it.countdownEndTime)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        binding.parsedDatesTextview.text = DateParseUtils.parseDateStrings(resources.getStringArray(R.array.test_date_strings)).let {
            it.joinToString(separator = "\n\n") { item -> "\"" + item.first + "\"\n" + DateTimeFormat.longDateTime().print(item.second) }
        }
    }

    private fun startCountDown() = flow {
        while (true) {
            delay(1000)
            emit(DateCountdownUtils.computeCountdownTime())
        }
    }.flowOn(Dispatchers.Default)
}