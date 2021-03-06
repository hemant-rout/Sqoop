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
package org.apache.sqoop.shell;

import static org.apache.sqoop.shell.ShellEnvironment.client;
import static org.apache.sqoop.shell.ShellEnvironment.resourceString;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.OptionBuilder;
import org.apache.sqoop.model.MSubmission;
import org.apache.sqoop.shell.core.Constants;
import org.apache.sqoop.shell.utils.SubmissionDisplayer;
import org.apache.sqoop.submission.SubmissionStatus;
import org.apache.sqoop.validation.Status;

@SuppressWarnings("serial")
public class ShowJobStatusFunction extends SqoopFunction {
  private static final long serialVersionUID = 1L;

  @SuppressWarnings("static-access")
  public ShowJobStatusFunction() {
    this.addOption(OptionBuilder.hasArg().withArgName(Constants.OPT_NAME)
       .withDescription(resourceString(Constants.RES_PROMPT_JOB_NAME))
       .withLongOpt(Constants.OPT_NAME)
       .create(Constants.OPT_NAME_CHAR));
  }

  @Override
  public Object executeFunction(CommandLine line, boolean isInteractive) {
    if (line.hasOption(Constants.OPT_NAME)) {
      MSubmission submission = client.getJobStatus(line.getOptionValue(Constants.OPT_NAME));
      if(submission.getStatus().isFailure() || submission.getStatus().equals(SubmissionStatus.SUCCEEDED)) {
        SubmissionDisplayer.displayHeader(submission);
        SubmissionDisplayer.displayFooter(submission);
      } else {
        SubmissionDisplayer.displayHeader(submission);
        SubmissionDisplayer.displayProgress(submission);
      }
    } else {
      return null;
    }

    return Status.OK;
  }
}
