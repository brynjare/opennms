/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2020 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2020 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.netmgt.events.api.model;

import org.junit.Test;
import org.opennms.core.test.xml.XmlTest;
import org.opennms.netmgt.xml.event.Autoacknowledge;

/**
 * A test class to verify mapping an immutability properties of '{@link ImmutableAutoAcknowledge}'.
 */
public class ImmutableAutoAcknowledgeTest {

    @Test
    public void test() {
        Autoacknowledge autoacknowledge = new Autoacknowledge();
        autoacknowledge.setContent("test-value");
        autoacknowledge.setState("on");

        // Mutable to Immutable
        IAutoAcknowledge immutableAutoAcknowledge = ImmutableMapper.fromMutableAutoAcknowledge(autoacknowledge);

        // Immutable to Mutable
        Autoacknowledge convertedAutoAcknowledge = Autoacknowledge.copyFrom(immutableAutoAcknowledge);

        String expectedXml = XmlTest.marshalToXmlWithJaxb(autoacknowledge);
        String convertedXml = XmlTest.marshalToXmlWithJaxb(convertedAutoAcknowledge);
        XmlTest.assertXmlEquals(expectedXml, convertedXml);
    }
}
