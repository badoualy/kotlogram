package com.github.badoualy.telegram.mtproto.secure

import com.github.badoualy.telegram.mtproto.tl.MTMessage

class EncryptedMessage(val message: MTMessage, val data: ByteArray)