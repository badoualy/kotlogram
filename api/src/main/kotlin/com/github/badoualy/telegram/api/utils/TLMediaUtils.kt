package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.core.TLBytes

fun TLAbsMessageMedia.getLocation(): TLGeoPoint? = when (this) {
    is TLMessageMediaGeo -> if (geo is TLGeoPoint) geo as TLGeoPoint else null
    else -> null
}

fun TLMessageMediaGeo.getLocation(): TLGeoPoint? = when (geo) {
    is TLGeoPoint -> geo as TLGeoPoint
    else -> null
}

fun TLAbsMessageMedia.getAbsMediaInput() = when (this) {
    is TLMessageMediaContact -> null // nothing to download
    is TLMessageMediaDocument -> getMediaInput()
    is TLMessageMediaEmpty -> null // nothing to download
    is TLMessageMediaGeo -> null // nothing to download
    is TLMessageMediaPhoto -> getMediaInput()
    is TLMessageMediaUnsupported -> null // nothing to download
    is TLMessageMediaVenue -> null // nothing to download
    is TLMessageMediaWebPage -> getMediaInput()
    else -> null
}

fun TLAbsMessageMedia.getAbsMediaThumbnailInput() = when (this) {
    is TLMessageMediaContact -> null // nothing to download
    is TLMessageMediaDocument -> getMediaThumbnailInput()
    is TLMessageMediaEmpty -> null // nothing to download
    is TLMessageMediaGeo -> null // nothing to download
    is TLMessageMediaPhoto -> getMediaThumbnailInput()
    is TLMessageMediaUnsupported -> null // nothing to download
    is TLMessageMediaVenue -> null // nothing to download
    is TLMessageMediaWebPage -> getMediaThumbnailInput()
    else -> null
}

fun TLMessageMediaDocument.getMediaInput() = when (document) {
    is TLDocument -> {
        val document = document as TLDocument
        val inputFileLocation = InputFileLocation(TLInputDocumentFileLocation(document.id, document.accessHash, document.version), document.dcId)
        MediaInput(inputFileLocation, document.size, document.mimeType)
    }
    else -> null
}

fun TLMessageMediaDocument.getMediaThumbnailInput() = when (document) {
    is TLDocument -> (document as TLDocument).thumb.getMediaInput()
    else -> null
}

fun TLMessageMediaPhoto.getMediaInput() = when (photo) {
    is TLPhoto -> (photo as TLPhoto).sizes.getMaxSize()?.getMediaInput()
    else -> null
}

fun TLMessageMediaPhoto.getMediaThumbnailInput() = when (photo) {
    is TLPhoto -> (photo as TLPhoto).sizes.getMinSize()?.getMediaInput()
    else -> null
}

fun TLMessageMediaWebPage.getMediaInput() = when (webpage) {
    is TLWebPage -> {
        val photo = (webpage as TLWebPage).photo
        if (photo is TLPhoto)
            photo.sizes.getMaxSize()?.getMediaInput()
        else null
    }
    else -> null
}

fun TLMessageMediaWebPage.getMediaThumbnailInput() = when (webpage) {
    is TLWebPage -> {
        val photo = (webpage as TLWebPage).photo
        if (photo is TLPhoto)
            photo.sizes.getMinSize()?.getMediaInput()
        else null
    }
    else -> null
}

fun TLAbsPhotoSize?.getMediaInput() = when (this) {
    is TLPhotoSize -> {
        val inputFileLocation = location.toInputFileLocation()
        if (inputFileLocation != null)
            MediaInput(inputFileLocation, size, "image/jpeg")
        else null
    }
    is TLPhotoCachedSize -> {
        val inputFileLocation = location.toInputFileLocation()
        if (inputFileLocation != null)
            MediaInput(inputFileLocation, bytes.length, "image/jpeg", bytes)
        else null
    }
    else -> null
}

fun Collection<TLAbsPhotoSize>?.getMaxSize(): TLAbsPhotoSize? {
    if (this == null || isEmpty())
        return null

    val maxSize = filterIsInstance<TLPhotoSize>().sortedByDescending { it.w * it.h }.firstOrNull()
    if (maxSize != null)
        return maxSize

    // No TLPhotoSize, look for cached size
    return filterIsInstance<TLPhotoCachedSize>().firstOrNull()
}

fun Collection<TLAbsPhotoSize>?.getMinSize(): TLAbsPhotoSize? {
    if (this == null || isEmpty())
        return null

    // Look for cached size
    val minSize = filterIsInstance<TLPhotoCachedSize>().firstOrNull()
    if (minSize != null)
        return minSize

    return filterIsInstance<TLPhotoSize>().sortedBy { it.w * it.h }.firstOrNull()
}

fun TLAbsFileLocation.toInputFileLocation() = when (this) {
    is TLFileLocation -> InputFileLocation(TLInputFileLocation(volumeId, localId, secret), dcId)
    is TLFileLocationUnavailable -> null
    else -> null
}

data class MediaInput(val inputFileLocation: InputFileLocation, val size: Int, val mimeType: String, val cached: TLBytes? = null)
data class InputFileLocation(val inputFileLocation: TLAbsInputFileLocation, val dcId: Int)