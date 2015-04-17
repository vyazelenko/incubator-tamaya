/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tamaya.core.internal.converters;

import org.apache.tamaya.spi.PropertyConverter;

import java.util.Locale;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Converter, converting from String to Boolean, the supported format is one of the following:
 * <ul>
 *     <li>true</li>
 *     <li>t</li>
 *     <li>yes</li>
 *     <li>y</li>
 *     <li>1</li>
 *     <li>0</li>
 * </ul>
 */
public class BooleanConverter implements PropertyConverter<Boolean> {

    private Logger LOG = Logger.getLogger(getClass().getName());

    @Override
    public Boolean convert(String value) {
        String ignoreCaseValue = Objects.requireNonNull(value)
                                        .trim()
                                        .toLowerCase(Locale.ENGLISH);
        switch(ignoreCaseValue) {
            case "yes":
            case "y":
            case "true":
            case "t":
            case "1":
                return Boolean.TRUE;
            case "no":
            case "n":
            case "false":
            case "f":
            case "0":
                return Boolean.FALSE;
            default:
                LOG.finest("Unknown boolean value encountered: " + value);
                return null;
        }
    }
}
