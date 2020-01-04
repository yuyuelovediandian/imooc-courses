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

package com.crazyhzm.crazyrpc.remoting.transport;

import com.crazyhzm.crazyrpc.remoting.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: crazyhzm
 * @Date: Created in 2019-12-23 18:05
 */
public class RpcReadTimeoutHandler extends ReadTimeoutHandler {

    private ClientHandler handler;

    private long timeout;

    public RpcReadTimeoutHandler(ClientHandler handler, long timeout, TimeUnit milliseconds) {
        super(timeout, milliseconds);
        this.handler = handler;
        this.timeout = timeout;
    }

    @Override
    protected void readTimedOut(ChannelHandlerContext ctx) throws Exception {
        Response rpcResponse = new Response();
        rpcResponse.setSuccess(false);
        rpcResponse.setError(new RuntimeException("访问服务端超时,timeout=" + timeout + "ms"));
        handler.setResponse(rpcResponse);
        super.readTimedOut(ctx);
    }
}
