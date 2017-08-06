package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.secure.RandomUtils
import org.slf4j.LoggerFactory

object Kotlogram {

    private val logger = LoggerFactory.getLogger(Kotlogram::class.java)!!

    @JvmField
    val API_LAYER = 66

    init {
        logger.info("""
         __  ___   ______   .___________. __        ______     _______ .______          ___      .___  ___.
        |  |/  /  /  __  \  |           ||  |      /  __  \   /  _____||   _  \        /   \     |   \/   |
        |  '  /  |  |  |  | `---|  |----`|  |     |  |  |  | |  |  __  |  |_)  |      /  ^  \    |  \  /  |
        |    <   |  |  |  |     |  |     |  |     |  |  |  | |  | |_ | |      /      /  /_\  \   |  |\/|  |
        |  .  \  |  `--'  |     |  |     |  `----.|  `--'  | |  |__| | |  |\  \----./  _____  \  |  |  |  |
        |__|\__\  \______/      |__|     |_______| \______/   \______| | _| `._____/__/     \__\ |__|  |__|
        Using layer $API_LAYER
        """)
    }

    @JvmOverloads @JvmStatic
    fun getDefaultClient(application: TelegramApp, apiStorage: TelegramApiStorage,
                         updateCallback: UpdateCallback? = null,
                         preferredDataCenter: DataCenter = PROD_DC4,
                         tag: String = RandomUtils.randomInt().toString())
            : TelegramClient = DefaultTelegramClient(application, apiStorage, updateCallback, preferredDataCenter, tag)

    @JvmStatic
    fun shutdown() {
        logger.warn("==================== SHUTTING DOWN ====================")
        TelegramClientPool.DEFAULT_POOL.shutdown()
        TelegramClientPool.DOWNLOADER_POOL.shutdown()
        MTProtoHandler.shutdown()
        logger.warn("==================== SHUT DOWN DONE ====================")
    }

    @JvmField val PROD_DC1 = DataCenter("149.154.175.50", 443)
    @JvmField val PROD_DC2 = DataCenter("149.154.167.51", 443)
    @JvmField val PROD_DC3 = DataCenter("149.154.175.100", 443)
    @JvmField val PROD_DC4 = DataCenter("149.154.167.91", 443) // 149.154.166.120
    @JvmField val PROD_DC5 = DataCenter("91.108.56.165", 443)

    private val PROD_DC1_IP6 = DataCenter("2001:0b28:f23d:f001:0000:0000:0000:000a", 443)
    private val PROD_DC2_IP6 = DataCenter("2001:067c:04e8:f002:0000:0000:0000:000a", 443)
    private val PROD_DC3_IP6 = DataCenter("2001:0b28:f23d:f003:0000:0000:0000:000a", 443)
    private val PROD_DC4_IP6 = DataCenter("2001:067c:04e8:f004:0000:0000:0000:000a", 443)
    private val PROD_DC5_IP6 = DataCenter("2001:0b28:f23f:f005:0000:0000:0000:000a", 443)

    @JvmField
    val PROD_DCS = arrayOf(PROD_DC1, PROD_DC2, PROD_DC3, PROD_DC4, PROD_DC5)

    @JvmStatic
    fun getDcById(id: Int) = PROD_DCS[id - 1]

    @JvmStatic
    fun getDcId(dataCenter: DataCenter) = PROD_DCS.indexOf(dataCenter) + 1
}

