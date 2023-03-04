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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.dogla.treetable.util.RowVisitor;
import io.github.dogla.treetable.util.RowWalker;

/**
 * The base class for a tree/table structure.
 *
 * @author Dominik
 */
public class TreeTable implements RowContainer {
	
	private Map<String, Object> parameters = new HashMap<>();
	private Column[] columns;
	private List<Row> rows = new ArrayList<>();

	/**
	 * Constructor.
	 *
	 * @param columns
	 */
	public TreeTable(String... columns) {
		this(Arrays.stream(columns).map(c -> new Column(c)).toArray(Column[]::new));
	}

	/**
	 * Constructor.
	 *
	 * @param columns
	 */
	public TreeTable(Column[] columns) {
		super();
		this.columns = columns;
	}
	
	/**
	 * Copy Constructor.
	 *
	 * @param treeTable the tree table to copy
	 */
	public TreeTable(TreeTable treeTable) {
		this.columns = new Column[treeTable.columns.length];
		for (int i = 0; i < columns.length; i++) {
			columns[i] = treeTable.columns[i].copy();
		}
		for (Row row : treeTable.rows) {
			rows.add(row.copy(null, columns));
		}
		this.parameters = new HashMap<>(treeTable.parameters);
	}

	/**
	 * @return the columns
	 */
	public Column[] getColumns() {
		return columns;
	}

	@Override
	public Row[] getRows() {
		return rows.toArray(new Row[rows.size()]);
	}
	
	/**
	 * Adds the given cells to the given row.
	 * 
	 * @param parent the parent row
	 * @param cells the cells to add
	 * 
	 * @return the new row
	 */
	public Row addRow(Row parent, Object... cells) {
		if (parent == null) {
			return addRow(cells);
		} else {
			return parent.addRow(cells);
		}
	}

	@Override
	public Row addRow(Object... cells) {
		Row row = new Row(columns, cells);
		this.rows.add(row);
		return row;
	}
	
	/**
	 * Sorts the rows by the given comparator.
	 * 
	 * @param comparator the comparator
	 */
	public void sort(Comparator<Row> comparator) {
		Collections.sort(rows, comparator);
	}
	
	/**
	 * @return <code>true</code> if at least one row as sub rows.
	 */
	public boolean isTree() {
		return rows.stream().anyMatch(r -> r.hasRows());
	}
	
	@Override
	public String toString() {
		return toText();
	}
	
	/**
	 * @return the default text representation of the given tree/table 
	 */
	public String toText() {
		return toText(new TreeTableToTextConverter());
	}

	/**
	 * @param handler the handler to convert the underlying tree/table to the corresponding text
	 * 
	 * @return the corresponding text
	 */
	public String toText(TreeTableToTextConverter handler) {
		return convert(handler);
	}
	
	/**
	 * Converts the underlying tree/table.
	 * 
	 * @param converter the converter
	 * 
	 * @return the result of the conversion
	 */
	public <T> T convert(TreeTableConverter<T> converter) {
		return converter.convert(this);
	}

	@Override
	public void walk(RowVisitor visitor) {
		new RowWalker(visitor).walk(this);
	}

	/**
	 * Copies the given tree.
	 * 
	 * @return the copied tree
	 */
	public TreeTable copy() {
		return new TreeTable(this);
	}

	@Override
	public boolean hasRows() {
		return !rows.isEmpty();
	}

	@Override
	public int depth() {
		return rows.stream().mapToInt(r -> r.depth()).max().orElseGet(() -> 0);
	}

	/**
	 * @return the parameters assigned to the given tree
	 */
	public Map<String, Object> getParameters() {
		return parameters;
	}

}
