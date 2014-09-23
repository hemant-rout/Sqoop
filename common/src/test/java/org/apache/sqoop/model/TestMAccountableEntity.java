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
package org.apache.sqoop.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
 * Test class for org.apache.sqoop.model.MAccountableEntity
 */
public class TestMAccountableEntity {

  /**
   * Test for class initialization
   */
  @Test
  public void testInitialization() {
    List<MForm> forms = new ArrayList<MForm>();
    MIntegerInput input = new MIntegerInput("INTEGER-INPUT", false);
    List<MInput<?>> list = new ArrayList<MInput<?>>();
    list.add(input);
    MForm form = new MForm("FORMNAME", list);
    forms.add(form);
    MAccountableEntity link = new MLink(123l, new MConnectionForms(
        forms), new MConnectionForms(forms));
    // Initially creation date and last update date is same
    assertEquals(link.getCreationDate(), link.getLastUpdateDate());
    Date testCreationDate = new Date();
    Date testLastUpdateDate = new Date();
    link.setCreationUser("admin");
    link.setCreationDate(testCreationDate);
    link.setLastUpdateUser("user");
    link.setLastUpdateDate(testLastUpdateDate);
    link.setEnabled(false);
    assertEquals(testCreationDate, link.getCreationDate());
    assertEquals("admin", link.getCreationUser());
    assertEquals(testLastUpdateDate, link.getLastUpdateDate());
    assertEquals(false, link.getEnabled());
    assertEquals("user", link.getLastUpdateUser());
  }
}
