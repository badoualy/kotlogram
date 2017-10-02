package com.github.badoualy.telegram.tl.builder.parser

fun TLType.isTrueFalseFlag() = this is TLTypeRaw && arrayOf("true", "false").contains(name)