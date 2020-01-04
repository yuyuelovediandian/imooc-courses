/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.crazyhzm.crazyrpc.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Description:
 * @Author: crazyhzm
 * @Date: Created in 2019-12-23 01:10
 */
public class NamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("application", new SimpleBeanDefinitionParser(ApplicationConfig.class));
        registerBeanDefinitionParser("server", new SimpleBeanDefinitionParser(ServerConfig.class));
        registerBeanDefinitionParser("register", new SimpleBeanDefinitionParser(RegisterConfig.class));
        registerBeanDefinitionParser("service", new SimpleBeanDefinitionParser(ServiceConfig.class));
        registerBeanDefinitionParser("client", new SimpleBeanDefinitionParser(ClientConfig.class));
        registerBeanDefinitionParser("reference", new SimpleBeanDefinitionParser(ReferenceConfig.class));
    }
}
