package com.github.badoualy.telegram.mtproto.exception

import com.github.badoualy.telegram.mtproto.tl.MTRpcError

class RpcErrorException(val error: MTRpcError) : Exception(error.errorCode.toString() + ": " + error.message)
