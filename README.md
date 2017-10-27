![Kotlogram](http://s28.postimg.org/u3sc3e24t/logo.png)<br/>
[![Release](https://jitpack.io/v/badoualy/kotlogram.svg)](https://jitpack.io/#badoualy/kotlogram) [![Build Status](https://travis-ci.org/badoualy/kotlogram.svg?branch=master)](https://travis-ci.org/badoualy/kotlogram)

Current layer: 72
===========
Documentation@[http://kotlogram.badoualy.com](http://kotlogram.badoualy.com)
===========

> **Easy to use** and **straightforward** Kotlin (and Java) binding of [Telegram API](https://core.telegram.org/api).
> The project is coded in **Kotlin**, with some classes (mostly generated and legacy classes) in Java

Kotlin, what is that, I don't know this language!
----------------
Don't worry, Kotlin is a JVM language just like Java and Scala, and is fully interoperable with Java! You can use this as a standard Java Library.
Kotlogram uses Kotlin to improve the usability of the lib. The TL Language used by Telegram's protocol as used requires a lot of boilerplate code when modeled in a language like Java. To be more developer-friendly, the lib includes a lot of utils in the form of Kotlin extension functions and properties.

TODO list
----------------
- Implement CDN redirection handling when downloading files.

Important notes
----------------
This documentation's only purpose is to explain how the library works, and how to use it. Telegram documentation is sadly completely outdated and not of any use. Probably at some point in the future they'll either close the public API, or release new documentation (I'm hoping for the latter).
But this documentation **will not explain how to use their API**, like how to get messages older than the date `X` or all the parameters of a rpc method.
Please, restrain from opening ticket about questions on the API, as I'll ignore them if I don't have the answer.

Usage
----------------
#### Dependency

First, add [JitPack](https://jitpack.io/) to your project if that's not already the case, in your `build.gradle`:

```gradle
repositories {
    // ...
    maven { url "https://jitpack.io" }
}
```

Then add the library dependency:
```gradle
compile 'com.github.badoualy:kotlogram:1.0.0-RC3'
```

Licence
----------------
```
The MIT License (MIT)

Copyright (c) 2015 Yannick Badoual

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
