package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputReportReasonOther#e1746d0a][TLInputReportReasonOther]
 * * [inputReportReasonPornography#2e59d922][TLInputReportReasonPornography]
 * * [inputReportReasonSpam#58dbcab8][TLInputReportReasonSpam]
 * * [inputReportReasonViolence#1e22c78d][TLInputReportReasonViolence]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsReportReason : TLObject()
