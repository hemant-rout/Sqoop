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
package org.apache.sqoop.validation;


/**
 * Link and Job config validator.
 *
 * This class should be extended by connector to provide configuration
 * validation for link and job configuration objects.
 */
public class Validator {

  /**
   * Validate link configuration object.
   *
   * @param linkConfiguration Connection object to be validated
   * @return Validation status
   */
  public Validation validateLink(Object linkConfiguration) {
    return new Validation(EmptyClass.class);
  }

  /**
   * Validate configuration object for job .
   *
   * @param jobConfiguration Job to be validated
   * @return Validation status
   */
  public Validation validateJob(Object jobConfiguration) {
    return new Validation(EmptyClass.class);
  }

  /**
   * Private class with no properties to properly create dump validation
   * objects.
   */
  private class EmptyClass {
  }
}
