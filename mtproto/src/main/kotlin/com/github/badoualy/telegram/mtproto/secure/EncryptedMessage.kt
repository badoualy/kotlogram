package com.github.badoualy.telegram.mtproto.secure

import com.github.badoualy.telegram.mtproto.tl.MTProtoMessage

class EncryptedMessage(val message: MTProtoMessage, val data: ByteArray)