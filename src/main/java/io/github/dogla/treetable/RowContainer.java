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
package io.github.dogla.treetable;

import io.github.dogla.treetable.util.RowVisitor;

/**
 * The interface of a row container.
 *
 * @author Dominik Glaser
 */
public interface RowContainer {

	/**
	 * Creates a new row with the given cells and adds the row to the underlying container.
	 * 
	 * @param cells the cells to add
	 * 
	 * @return the new row
	 */
	Row addRow(Object... cells);

	/**
	 * @return all rows of the container
	 */
	Row[] getRows();

	/**
	 * @return <code>true</code> if the container has rows
	 */
	boolean hasRows();

	/**
	 * 
	 * @return the depth of the container
	 */
	int depth();

	/**
	 * Walks to the structure of the underlying row container and calls the corresponding callbacks of the given row visitor.
	 * 
	 * @param visitor the row visitor
	 */
	void walk(RowVisitor visitor);

}