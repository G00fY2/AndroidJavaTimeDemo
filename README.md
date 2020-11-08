# AndroidJavaTimeDemo
This repo contains an Android app with simple date usecases, implemented with different frameworks/libraries. The idea is to compare the dex count and APK size.

## Usecases
* start a hardcoded countdown to the next Sunday 19:00:00 Central European Time (CET)
* parse different ISO 8601 strings, typically used when communicating with a backend

## Implementations
There are 5 branches, each using a different technology

* [koitlinx-datetime core library desugaring](https://github.com/G00fY2/AndroidJavaTimeDemo/tree/kotlinx)
* [java.time core library desugaring](https://github.com/G00fY2/AndroidJavaTimeDemo/tree/JavaTime)
* [ThreeTenABP Android](https://github.com/G00fY2/AndroidJavaTimeDemo/tree/ThreeTenABP)
* [JodaTime Android](https://github.com/G00fY2/AndroidJavaTimeDemo/tree/JodaTime)
* [SimpleDateFormat](https://github.com/G00fY2/AndroidJavaTimeDemo/tree/SimpleDateFormat)

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

