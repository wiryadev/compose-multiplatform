/*
 * Copyright 2020-2021 JetBrains s.r.o. and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

@file:Suppress("UNUSED", "NOTHING_TO_INLINE", "FunctionName")
package org.jetbrains.compose.web.css

interface StylePropertyValue

interface StylePropertyNumber: StylePropertyValue
interface StylePropertyString: StylePropertyValue

inline fun StylePropertyValue(value: String): StylePropertyString = value.asDynamic().unsafeCast<StylePropertyString>()
inline fun StylePropertyValue(value: Number): StylePropertyNumber = value.asDynamic().unsafeCast<StylePropertyNumber>()

interface CSSStyleValue: StylePropertyValue {
    override fun toString(): String
}

inline fun CSSStyleValue(value: String): CSSStyleValue = StylePropertyValue(value).asDynamic().unsafeCast<CSSStyleValue>()
