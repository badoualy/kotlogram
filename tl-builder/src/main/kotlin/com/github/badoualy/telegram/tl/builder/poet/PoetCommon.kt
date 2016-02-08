package com.github.badoualy.telegram.tl.builder.poet

import com.github.badoualy.telegram.tl.builder.uCamelCase
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeName
import javax.lang.model.element.Modifier

fun generateGetter(realName: String, fieldName: String, fieldType: TypeName) =
        MethodSpec.methodBuilder("get${realName.uCamelCase()}")
                .addModifiers(Modifier.PUBLIC)
                .returns(fieldType)
                .addStatement("return $fieldName")
                .build()

fun generateSetter(realName: String, fieldName: String, fieldType: TypeName) =
        MethodSpec.methodBuilder("set${realName.uCamelCase()}")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(fieldType, fieldName)
                .addStatement("this.$fieldName = $fieldName")
                .build()