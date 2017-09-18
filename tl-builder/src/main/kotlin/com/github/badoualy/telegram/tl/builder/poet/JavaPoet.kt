package com.github.badoualy.telegram.tl.builder.poet

//        apiMethod = MethodSpec.methodBuilder(method.name.lCamelCase())
//                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
//                .addException(TYPE_RPC_EXCEPTION).addException(IOException::class.java)
//                .returns(responseType)
//        apiWrappedMethod = MethodSpec.methodBuilder(method.name.lCamelCase())
//                .addModifiers(Modifier.PUBLIC).addAnnotation(Override::class.java)
//                .addException(TYPE_RPC_EXCEPTION).addException(IOException::class.java)
//                .returns(responseType)
//                .addStatement("return (\$T) executeRpcQuery(new \$T(\$L))",
//                              responseType,
//                              clazzTypeName,
//                              if (method.parameters.isNotEmpty())
//                                  method.parameters.filterNot { it.tlType is TLTypeFlag }.map { it.name.lCamelCase().javaEscape() }.joinToString(", ")
//                              else "")