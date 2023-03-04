/**
 * Copyright (C) 2022-2023 Dominik Glaser
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
package io.github.dogla.treetable.util;

/**
 * The result type for a {@link RowVisitor}.
 *
 * @author Dominik Glaser
 */
public enum RowVisitResult {

    /**
     * Continue.
     */
    CONTINUE,
    /**
     * Terminate.
     */
    TERMINATE,
    /**
     * Continue without visiting the <em>children</em> of this row.
     */
    SKIP_SUBTREE,
    /**
     * Continue without visiting the <em>siblings</em> of this row.
     */
    SKIP_SIBLINGS;

}
