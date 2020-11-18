# AndroidJavaTimeDemo
This repo contains an Android app with simple date usecases, implemented with different frameworks/libraries. The idea is to compare the dex count and APK size.

## Usecases
* start a hardcoded countdown to the next Sunday 19:00:00 Central European Time (CET)
* parse different ISO 8601 strings, typically used when communicating with a backend

## Implementations
There are 5 branches, each using a different technology (all using AGP 4.1.0, with D8/R8 enabled)

|     Branch    |     Version   |  Description  |
| ------------- | ------------- | ------------- |
| [kotlinx](https://github.com/G00fY2/AndroidJavaTimeDemo/tree/kotlinx) | 0.1.0 | [kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime) (which uses Java 8 [java.time](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html) through [core library desugaring](https://developer.android.com/studio/write/java8-support-table) on Android) |
| [JavaTime](https://github.com/G00fY2/AndroidJavaTimeDemo/tree/JavaTime) | 1.1.0 | Java 8 [java.time](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html) through [core library desugaring](https://developer.android.com/studio/write/java8-support-table) ([desugar_jdk_libs](https://github.com/google/desugar_jdk_libs)) |
| [JodaTime](https://github.com/G00fY2/AndroidJavaTimeDemo/tree/JodaTime) | 2.10.7.1 | [JodaTime Android](https://github.com/dlew/joda-time-android) library ([JodaTime](https://www.joda.org/joda-time/) with Android adjustments) |
| [ThreeTenABP](https://github.com/G00fY2/AndroidJavaTimeDemo/tree/ThreeTenABP) | 1.3.0 | [ThreeTenABP](https://github.com/JakeWharton/ThreeTenABP) library ([ThreeTenBP](https://www.threeten.org/threetenbp/) with Android adjustments) |
| [SimpleDateFormat](https://github.com/G00fY2/AndroidJavaTimeDemo/tree/SimpleDateFormat) | --- | [Date](https://developer.android.com/reference/java/util/Date), [SimpleDateFormat](https://developer.android.com/reference/java/text/SimpleDateFormat) and [Calendar](https://developer.android.com/reference/java/util/Calendar) |


## License
     The MIT License (MIT)

    Copyright (C) 2020 Thomas Wirth

    Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
    associated documentation files (the "Software"), to deal in the Software without restriction,
    including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
    and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
    subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all copies or substantial
    portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
    LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
    NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
    DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT
    OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

