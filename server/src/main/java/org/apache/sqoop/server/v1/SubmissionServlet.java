/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sqoop.server.v1;

import org.apache.sqoop.handler.SubmissionRequestHandler;
import org.apache.sqoop.json.JsonBean;
import org.apache.sqoop.server.RequestContext;
import org.apache.sqoop.server.RequestHandler;
import org.apache.sqoop.server.SqoopProtocolServlet;

/**
 *
 */
@SuppressWarnings("serial")
public class SubmissionServlet extends SqoopProtocolServlet {

  private RequestHandler submissionRequestHandler;

  public SubmissionServlet() {
    submissionRequestHandler = new SubmissionRequestHandler();
  }

  @Override
  protected JsonBean handleGetRequest(RequestContext ctx) throws Exception {
    return submissionRequestHandler.handleEvent(ctx);
  }

  @Override
  protected JsonBean handlePostRequest(RequestContext ctx) throws Exception {
    return submissionRequestHandler.handleEvent(ctx);
  }

  @Override
  protected JsonBean handleDeleteRequest(RequestContext ctx) throws Exception {
    return submissionRequestHandler.handleEvent(ctx);
  }
}
