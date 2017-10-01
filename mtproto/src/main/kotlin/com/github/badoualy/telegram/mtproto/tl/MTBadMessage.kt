package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.core.TLObject

abstract class MTBadMessage @JvmOverloads constructor(var badMsgId: Long = 0,
                                                      var badMsqSeqno: Int = 0,
                                                      var errorCode: Int = 0) : TLObject() {
    val errorMessage: String
        get() =
            when (errorCode) {
                16 -> "msg_id too low"
                17 -> "msg_id too high"
                18 -> "incorrect two lower order msg_id bits"
                19 -> "container msg_id is the same as msg_id of a previously received message"
                20 -> "message too old, and it cannot be verified whether the server has received a message with this msg_id or not"
                32 -> "msg_seqno too low"
                33 -> "msg_seqno too high"
                34 -> "an even msg_seqno expected (irrelevant message), but odd received"
                35 -> "odd msg_seqno expected (relevant message), but even received"
                48 -> "incorrect server salt"
                64 -> "invalid container"
                else -> ""
            }

    fun toPrettyString() = "{id: $badMsgId, seqNo: $badMsqSeqno, errorCode: $errorCode, errorMessage: $errorMessage}"

    companion object {
        @JvmField
        val ERROR_MSG_ID_TOO_LOW = 16
        @JvmField
        val ERROR_MSG_ID_TOO_HIGH = 17
        @JvmField
        val ERROR_MSG_ID_MODULO = 18
        @JvmField
        val ERROR_CONTAINER_MSG_ID_INCORRECT = 19
        @JvmField
        val ERROR_TOO_OLD = 20

        @JvmField
        val ERROR_SEQNO_TOO_LOW = 32
        @JvmField
        val ERROR_SEQNO_TOO_HIGH = 33
        @JvmField
        val ERROR_SEQNO_EXPECTED_EVEN = 34
        @JvmField
        val ERROR_SEQNO_EXPECTED_ODD = 35

        @JvmField
        val ERROR_BAD_SERVER_SALT = 48

        @JvmField
        val ERROR_BAD_CONTAINER = 64
    }
}
