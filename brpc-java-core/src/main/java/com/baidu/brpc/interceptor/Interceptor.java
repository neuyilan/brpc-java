/*
 * Copyright (c) 2018 Baidu, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.brpc.interceptor;

import com.baidu.brpc.protocol.RpcRequest;
import com.baidu.brpc.protocol.RpcResponse;

/**
 * The client or server intercepts the interface.
 * The reason for dividing the two functions is that in the asynchronous scenario,
 * the request and response cannot be obtained at the same time.
 */
public interface Interceptor {
    /**
     * This method is called in two scenarios:
     * Before the client sends the request;
     * Before the server processes the request.
     * @param rpcRequest request content, when the business is implemented, it needs to be converted into the type
     *                   required by the specific protocol.
     * @return True means continue execution, false means stop execution and return
     */
    boolean handleRequest(RpcRequest rpcRequest);

    /**
     * This method is called in two scenarios:
     * Before the server sends the response;
     * After the client receives the response.
     * @param response server response content, when the business is implemented, it needs to be converted into the type
     */
    void handleResponse(RpcResponse response);
}
