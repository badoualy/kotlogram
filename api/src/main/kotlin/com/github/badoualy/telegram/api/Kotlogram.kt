package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.model.DataCenter
import org.slf4j.LoggerFactory

object Kotlogram {

    val logger = LoggerFactory.getLogger(Kotlogram::class.java)

    val API_LAYER = 53

    init {
        logger.warn("""
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
    fun getDefaultClient(application: TelegramApp, apiStorage: TelegramApiStorage, preferredDataCenter: DataCenter = PROD_DC4,
                         updateCallback: UpdateCallback? = null)
            : TelegramClient = DefaultTelegramClient(application, apiStorage, preferredDataCenter, updateCallback)

    @JvmStatic
    fun cleanUp() {
        logger.warn("==================== CLEANING ====================")
        TelegramClientPool.DEFAULT_POOL.cleanUp()
        TelegramClientPool.DOWNLOADER_POOL.cleanUp()
        MTProtoHandler.cleanUp()
        logger.warn("==================== CLEANED ====================")
    }

     @JvmField val PROD_DC1 = DataCenter("149.154.175.50", 443)
     @JvmField val PROD_DC2 = DataCenter("149.154.167.51", 443)
     @JvmField val PROD_DC3 = DataCenter("149.154.175.100", 443)
     @JvmField val PROD_DC4 = DataCenter("149.154.167.91", 443)
     @JvmField val PROD_DC5 = DataCenter("91.108.56.165", 443)

     @JvmField val PROD_DCS = arrayOf(PROD_DC1, PROD_DC2, PROD_DC3, PROD_DC4, PROD_DC5)

    @JvmStatic
    fun getDcById(id: Int) = PROD_DCS[id - 1]

    @JvmStatic
    fun getDcId(dataCenter: DataCenter) = PROD_DCS.indexOf(dataCenter) + 1
}

