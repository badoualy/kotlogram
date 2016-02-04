![Kotlogram](http://s28.postimg.org/u3sc3e24t/logo.png)
[![Release](https://jitpack.io/v/badoualy/kotlogram.svg)](https://jitpack.io/#badoualy/kotlogram)
===========
> **Easy to use** and **straightforward** Kotlin (and Java) binding of [Telegram API](https://core.telegram.org/api).
> The project is coded in **Kotlin**, with some classes (mostly legacy classes cloned from ex3nder library, see below for more details)
> The Java code will be replaced by Kotlin over time

> **Kotlin, what is that, I don't know this language!** 
> Don't worry, Kotlin is a JVM language just like Java and Scala, and is interoperable with Java! You can use this as a standard Java Library

Beta
----------------
The project is still in beta, a lot is yet to be done. It comes with absolutely no warranty!
Main tasks left:
- Implement [Perfect Forward Secrecy](https://core.telegram.org/api/pfs).
- Improve error handling for the requests, and the exceptions in the mtproto module.
- Implement tests

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
compile 'com.github.badoualy:kotlogram:0.0.4'
```


#### Example
You need to implement your own C class holding all the constants, it's not included in the repository since it contains confidential information such as my phone number, api id, ...
```java
// Activate debug log or not, false by default
// Kotlogram.setDebugLogEnabled(true);

// Replace the following constants with your app's information
// This informations are used in initConnection and sendCode rpc methods
TelegramApp app = new TelegramApp(C.API_ID, C.API_HASH, C.MODEL, C.SYSTEM_VERSION, C.APP_VERSION, C.LANG_CODE);

// This is a synchronous client, that will block until the response arrive (or until timeout)
// A client which return an Observable<T> where T is the response type will be available soon
TelegramClient client = Kotlogram.getDefaultClient(app, new ApiStorage());

// You can start making requests
try {
    // Send code to account
    TLAbsSentCode sentCode = client.authSendCode(C.PHONE_NUMBER, 5);
    System.out.println("Authentication code: ");
    String code = new Scanner(System.in).nextLine();

    // Auth with the received code
    TLAuthorization authorization = client.authSignIn(C.PHONE_NUMBER, sentCode.getPhoneCodeHash(), code);
    TLUser self = authorization.getUser().getAsUser();
    System.out.println("You are now signed in as " + self.getFirstName() + " " + self.getLastName());

    // Start making cool stuff!
    // Get a list of 10 most recent conversations
    TLAbsDialogs dialogs = client.messagesGetDialogs(0, 0, new TLInputPeerEmpty(), 10);
    for (TLAbsMessage message : dialogs.getMessages()) {
if (message instanceof TLMessage) {
    System.out.println("Found message " + ((TLMessage) message).getMessage());
} else {
    System.out.println("Found a service message or empty message");
}
    }

    // Take the first user in the list, and send a message to him
    // It'll probably be Telegram bot, since he'll send you the code
    TLUser randomUser = dialogs.getUsers().get(0).getAsUser();
    TLInputPeerUser inputUser = new TLInputPeerUser(randomUser.getId(), randomUser.getAccessHash());
    int randomId = new Random(System.currentTimeMillis()).nextInt();
    client.messagesSendMessage(0, false, false, inputUser, 0, "Kotlogram is awesome!", randomId, null, null);
    System.out.println("Message sent");
} catch (RpcErrorException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    client.close(); // Important, do not forget this, or your process won't finish
}
System.out.println("------------------------- GOOD BYE");
```


Structure
----------------
The project is composed by the following modules:
- [tl-builder: Type Language compiler](#tl-builder-type-language-compiler)
- [tl: Type Language library](#tl-type-language-library)
- [mtproto: MTProto Mobile Protocol library](#mtproto-mtproto-mobile-protocol-implementation)
- [api](#api)


tl-builder: [Type Language](http://core.telegram.org/mtproto/TL) compiler
----------------
Converts json-representation of [TL Schema](http://core.telegram.org/schema) to Java classes with generated classes for serializing and deserializing api messages and methods to their binary representation (see [Binary Data Serialization](https://core.telegram.org/mtproto/serialize)).
Used JavaPoet to rewrite it from scratch, original version from ex3nder was way to sloppy and used 3 different model layers for no reason.
#### Usage
1. Run the main class in tl-builder module with the layer value

The classes will be generated in the ```tl``` module in the package ```com.github.badoualy.telegram.tl.api```.


tl: [Type Language]() library
----------------
Contains the base type of the Type Language (int, long, Vecor, ...) and the classes generated by the ```tl-builder```. This module is the lowest level in the library, it supplies all the necessary classes to serialize/deserialize objects describe in the [TL Schema](https://core.telegram.org/schema).
#### About TL Language
"*TL Language (Type Language or Time Limit) serves to describe the used system of types, constructors, and existing functions. In fact, the combinator description format presented in Binary Data Serialization is used.*"


mtproto: [MTProto Mobile Protocol](https://core.telegram.org/mtproto) library
----------------
Contains all the necessary stuff to make RPC (Remote Procedure Call) and handle all the low-level stuff (like handling salt, etc.)
#### About MTProto..

**MTProto** is the [Telegram Messenger](http://www.telegram.org ) protocol 
_"designed for access to a server API from applications running on mobile devices"_.

The Mobile Protocol is subdivided into three components ([from the official site](https://core.telegram.org/mtproto#general-description)):

 - High-level component (API query language): defines the method whereby API 
 queries and responses are converted to binary messages.
 
 - Cryptographic (authorization) layer: defines the method by which messages 
 are encrypted prior to being transmitted through the transport protocol.      
 
 - Transport component: defines the method for the client and the server to transmit 
 messages over some other existing network protocol (such as, http, https, tcp, udp).


api
----------------
High-level API to easily use Telegram's [api methods](https://core.telegram.org/methods) without having to understand the first thing about MTProto or TL Language :)
An old fashioned Java API (like using [RestFB](https://github.com/restfb/restfb) or a any Rest API binding)

#### Usage
See [here](#Usage) for usage examples


[ex3ndr](https://github.com/ex3ndr)'s work
----------------
The different projects of ex3ndr are supposed to supply a library to use Telegram API without having to deal with the MTProto or Type Language, but for several reasons I found it impossible to use, mainly because the project is currently dead, which causes the following issues:
- The supplied version is based on Telegram API layer 12, current layer is 45. His builder to generate classes from the TL-Schema is not working with the new syntax.
- The [Type Language compiler](https://github.com/ex3ndr/telegram-tl) use a very old version of Kotlin, which means that if you clone the project, you won't be able to run it as it is. This complicates a lot the work to modify how the schema is compiled into Java classes.
More over, the generated classes are a mess and very difficult to read when needed.
- The architecture of the MTProto implementation is really complicated and not very straightforward.
- The ```AuthUtils``` class to execute the "Creating an Authorization Key" flow doesn't follow the [Perfect Forward Secrecy](https://core.telegram.org/api/pfs): you can only generate a permanent key.

For this reasons, the followings are based on his work:
- The **tl** module ```core``` package was cloned from (see [telegram-tl-core](https://github.com/ex3ndr/telegram-tl-core)) and modified for my needs.
- The **mtproto** module low-level classes (crypto/utils classes) are based on his implementation (cloned from his project and modified) (see [telegram-mt](https://github.com/ex3ndr/telegram-mt)).


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
