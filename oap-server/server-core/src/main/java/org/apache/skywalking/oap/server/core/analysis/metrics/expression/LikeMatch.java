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
 *
 */

package org.apache.skywalking.oap.server.core.analysis.metrics.expression;

import org.apache.skywalking.oap.server.core.analysis.metrics.annotation.FilterMatcher;

@FilterMatcher
public class LikeMatch {
    public boolean match(String left, String right) {
        if (left == null || right == null) {
            return false;
        }
        if (left.startsWith("%") && left.endsWith("%")) { // %keyword%
            return right.contains(left.substring(1, left.length() - 1));
        }
        return (left.startsWith("%") && right.endsWith(left.substring(1)))  // %suffix
            || (left.endsWith("%") && right.startsWith(left.substring(0, left.length() - 1))) // prefix%
            ;
    }
}