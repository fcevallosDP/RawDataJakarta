/*
 *  Copyright 2009-2022 PrimeTek.
 *
 *  Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.primefaces.layout.util;

public class StyleClassBuilder {

    private final StringBuilder sb;

    public StyleClassBuilder() {
        sb = new StringBuilder(16);
    }

    public StyleClassBuilder add(boolean condition, String styleClass) {
        if (condition) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(styleClass);
        }
        return this;
    }

    public StyleClassBuilder add(boolean condition, String styleClass, String notStyleClass) {
        return add(condition, styleClass).add(!condition, notStyleClass);
    }

    public StyleClassBuilder add(String styleClass) {
        return add(isNotBlank(styleClass), styleClass);
    }

    public StyleClassBuilder add(String defaultStyleClass, String userStyleClass) {
        return add(defaultStyleClass).add(userStyleClass);
    }

    public StyleClassBuilder addOrElse(String styleClass, String fallback) {
        if (isNotBlank(styleClass)) {
            return add(true, styleClass);
        }
        return add(fallback);
    }

    public String build() {
        String styleClass = sb.toString();
        sb.setLength(0);
        return styleClass;
    }

    public boolean isValueBlank(String value) {
        if (value == null || value.length() == 0) {
            return true;
        }

        return false;
    }

    public boolean isNotBlank(String value) {
        return !isValueBlank(value);
    }
}
