package com.g00fy2.androidjavatimedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.g00fy2.androidjavatimedemo.DateCountdownUtils.TIME_ZONE
import com.g00fy2.androidjavatimedemo.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            startCountDown().collect {
                binding.countdownTickerTextview.text = it.countdownTick.toString()

                binding.countdownNowLocalTextview.text = it.currentTime
                        .atZone(ZoneId.of(TIME_ZONE))
                        .withZoneSameInstant(ZoneId.systemDefault())
                        .toLocalDateTime()
                        .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault()))

                binding.countdownNowTextview.text = it.currentTime
                        .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.of(TIME_ZONE)))
                binding.countdownEndTextview.text = it.countdownEndTime
                        .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.of(TIME_ZONE)))
            }
        }
    }

    override fun onResume() {
        super.onResume()

        binding.parsedDatesTextview.text = DateParseUtils.parseDateStrings(resources.getStringArray(R.array.test_date_strings)).let {
            it.joinToString(separator = "\n\n") { item ->
                "\"" + item.first + "\"\n" + item.second.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault()))
            }
        }
    }

    private fun startCountDown() = flow {
        while (true) {
            delay(1000)
            emit(DateCountdownUtils.computeCountdownTime())
        }
    }.flowOn(Dispatchers.Default)
}