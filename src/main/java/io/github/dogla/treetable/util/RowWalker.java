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

import io.github.dogla.treetable.Row;
import io.github.dogla.treetable.TreeTable;

/**
 * Simple walker for the rows inside a {@link TreeTable}.
 *
 * @author Dominik Glaser
 */
public class RowWalker {

	private final RowVisitor visitor;
	private final int maxDepth;

	/**
	 * Constructor.
	 *
	 * @param visitor the visitor
	 */
	public RowWalker(RowVisitor visitor) {
		this(visitor, Integer.MAX_VALUE);
	}

	/**
	 * Constructor.
	 *
	 * @param visitor the visitor
	 * @param maxDepth the max depth
	 */
	public RowWalker(RowVisitor visitor, int maxDepth) {
		this.visitor = visitor;
		this.maxDepth = maxDepth;
	}

	/**
	 * Walks through the tree/row structure of the given {@link TreeTable}.
	 * 
	 * @param tree the {@link TreeTable}
	 */
	public void walk(TreeTable tree) {
		Row[] rows = tree.getRows();
		for (Row row : rows) {
			RowVisitResult result = walk(row, 1);

			// terminate tree walk
			if (result == null || result == RowVisitResult.TERMINATE) {
				return;
			}

			// skip remaining siblings in this directory
			if (result == RowVisitResult.SKIP_SIBLINGS) {
				break;
			}
		}
	}
	
	/**
	 * Walks through the tree/row structure of the given {@link Row}. 
	 * 
	 * @param row the starting row
	 */
	public void walk(Row row) {
		walk(row, 1);
	}
	
	/**
	 * @param file
	 *            the directory to visit
	 * @param depth
	 *            depth remaining
	 * @param ancestors
	 *            use when cycle detection is enabled
	 */
	private RowVisitResult walk(Row row, int depth) {
		// at maximum depth or file is not a directory
		if (depth >= maxDepth) {
			return RowVisitResult.SKIP_SIBLINGS;
		}

		final RowVisitResult result = visitor.visitRow(row);
		// terminate tree walk
		if (result == null || result == RowVisitResult.TERMINATE) {
			return RowVisitResult.TERMINATE;
		}

		// skip subtree
		if (result == RowVisitResult.SKIP_SUBTREE) {
			return result;
		}

		// skip sibling
		if (result == RowVisitResult.SKIP_SIBLINGS) {
			return result;
		}

		Row[] rows = row.getRows();
		for (Row entry : rows) {
			RowVisitResult subResult = walk(entry, depth + 1);

			// returning null will cause NPE to be thrown
			if (subResult == null || subResult == RowVisitResult.TERMINATE) {
				return subResult;
			}

			// skip remaining siblings in this directory
			if (subResult == RowVisitResult.SKIP_SIBLINGS) {
				break;
			}
		}

		return result;
	}
	
}
