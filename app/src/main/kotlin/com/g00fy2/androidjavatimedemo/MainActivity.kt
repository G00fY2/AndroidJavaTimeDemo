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
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.TimeZone

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            startCountDown().collect {
                binding.countdownTickerTextview.text = it.countdownTick.toString()

                val dateTimeFormat = SimpleDateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG)
                binding.countdownNowLocalTextview.text = dateTimeFormat.format(it.currentTime)

                dateTimeFormat.timeZone = TimeZone.getTimeZone(DateCountdownUtils.TIME_ZONE)
                binding.countdownNowTextview.text = dateTimeFormat.format(it.currentTime)
                binding.countdownEndTextview.text = dateTimeFormat.format(it.countdownEndTime)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        binding.parsedDatesTextview.text = DateParseUtils.parseDateStrings(resources.getStringArray(R.array.test_date_strings)).let {
            it.joinToString(separator = "\n\n") { item -> "\"" + item.first + "\"\n" + SimpleDateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(item.second) }
        }
    }

    private fun startCountDown() = flow {
        while (true) {
            delay(1000)
            emit(DateCountdownUtils.computeCountdownTime())
        }
    }.flowOn(Dispatchers.Default)
}