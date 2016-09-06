package com.github.badoualy.telegram.tl.builder.poet

import com.squareup.javapoet.ClassName

val PACKAGE_TL = "com.github.badoualy.telegram.tl"
val PACKAGE_TL_CORE = "$PACKAGE_TL.core"
val PACKAGE_TL_API = "$PACKAGE_TL.api"
val PACKAGE_TL_API_REQUEST = PACKAGE_TL_API + ".request"
val PACKAGE_TL_EXCEPTION = "$PACKAGE_TL.exception"

val TELEGRAM_API_INTERFACE = "TelegramApi"
val TELEGRAM_API_WRAPPER = "TelegramApiWrapper"
val TL_API_CONTEXT = "TLApiContext"
val TL_API_TEST_CONTEXT = "TLApiTestContext"

val TYPE_TELEGRAM_API = ClassName.get(PACKAGE_TL_API, TELEGRAM_API_INTERFACE)!!
val TYPE_TELEGRAM_API_WRAPPER = ClassName.get(PACKAGE_TL_API, TELEGRAM_API_WRAPPER)!!
val TYPE_TL_API_CONTEXT = ClassName.get(PACKAGE_TL_API, TL_API_CONTEXT)!!
val TYPE_TL_API_TEST_CONTEXT = ClassName.get(PACKAGE_TL_API, TL_API_TEST_CONTEXT)!!

val TYPE_STREAM_UTILS = ClassName.get(PACKAGE_TL, "StreamUtils")!!
val TYPE_TL_CONTEXT = ClassName.get(PACKAGE_TL, "TLContext")!!
val TYPE_DESERIALIZE_EXCEPTION = ClassName.get(PACKAGE_TL_EXCEPTION, "DeserializeException")!!
val TYPE_TLOBJECT_UTILS = ClassName.get(PACKAGE_TL, "TLObjectUtils")!!
val TYPE_RPC_EXCEPTION = ClassName.get(PACKAGE_TL_EXCEPTION, "RpcErrorException")!!

val TYPE_TL_BOOL = ClassName.get(PACKAGE_TL_CORE, "TLBool")!!
val TYPE_TL_BYTES = ClassName.get(PACKAGE_TL_CORE, "TLBytes")!!
val TYPE_TL_GZIP_OBJECT = ClassName.get(PACKAGE_TL_CORE, "TLGzipObject")!!
val TYPE_TL_INT_VECTOR = ClassName.get(PACKAGE_TL_CORE, "TLIntVector")!!
val TYPE_TL_LONG_VECTOR = ClassName.get(PACKAGE_TL_CORE, "TLLongVector")!!
val TYPE_TL_STRING_VECTOR = ClassName.get(PACKAGE_TL_CORE, "TLStringVector")!!
val TYPE_TL_VECTOR = ClassName.get(PACKAGE_TL_CORE, "TLVector")!!
val TYPE_TL_METHOD = ClassName.get(PACKAGE_TL_CORE, "TLMethod")!!
val TYPE_TL_OBJECT = ClassName.get(PACKAGE_TL_CORE, "TLObject")!!

val JAVADOC_AUTHOR = "@author Yannick Badoual yann.badoual@gmail.com\n"
val JAVADOC_SEE = "@see <a href=\"http://github.com/badoualy/kotlogram\">http://github.com/badoualy/kotlogram</a>\n"