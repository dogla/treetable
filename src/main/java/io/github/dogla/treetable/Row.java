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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import io.github.dogla.treetable.util.RowVisitor;
import io.github.dogla.treetable.util.RowWalker;

/**
 * The bean indentifying a row of the {@link TreeTable} structure.
 *
 * @author Dominik Glaser
 */
public class Row implements RowContainer {
	
	private Column[] columns;
	private Map<Column, Object> content = new HashMap<>();
	private ArrayList<Row> rows = new ArrayList<>();
	private Row parent;
	private Map<String, Object> parameters = new HashMap<>();
	private Object data;

	/**
	 * Constructor.
	 *
	 * @param columns the columns
	 * @param cells the cells
	 */
	/*package*/ Row(Column[] columns, Object[] cells) {
		this(null, columns, cells);
	}
	
	/**
	 * Constructor.
	 *
	 * @param parent the parent row
	 * @param columns the columns
	 * @param cells the cells
	 */
	/*package*/ Row(Row parent, Column[] columns, Object[] cells) {
		this.columns = columns;
		this.parent = parent;
		for (int i = 0; i < columns.length; i++) {
			Column column = columns[i];
			Object cellContent = ""; //$NON-NLS-1$
			if (cells != null && i < cells.length) {
				Object cell = cells[i];
				if (cell != null) {
					cellContent = cell;
				}
			}
			setCellContent(column, cellContent);
		}
	}

	/**
	 * @param column the column
	 * 
	 * @return the cell content of the given column
	 */
	public Object getCellContent(Column column) {
		return content.get(column);
	}

	/**
	 * Sets the cell content of the given column.
	 * 
	 * @param column the column
	 * @param cellContent the cell content
	 */
	public void setCellContent(Column column, Object cellContent) {
		content.put(column, cellContent);
	}

	@Override
	public Row addRow(Object... cells) {
		Row child = new Row(this, columns, cells);
		rows.add(child);
		return child;
	}
	
	/**
	 * Sorts the rows by the given comparator.
	 * 
	 * @param comparator the comparator
	 */
	public void sort(Comparator<Row> comparator) {
		Collections.sort(rows, comparator);
	}
	
	@Override
	public Row[] getRows() {
		return rows.toArray(new Row[rows.size()]);
	}
	
	@Override
	public boolean hasRows() {
		return !rows.isEmpty();
	}
	
	/**
	 * @return the parent row
	 */
	public Row parent() {
		return parent;
	}
	
	@Override
	public int depth() {
		int depth = 1;
		Row p = parent;
		while (p != null) {
			depth++;
			p = p.parent; 
		}
		return depth;
	}
	
	@Override
	public void walk(RowVisitor visitor) {
		new RowWalker(visitor).walk(this);
	}

	/**
	 * Copies the given row with all sub rows to the given parent row.
	 * 
	 * @param parent the parent row
	 * @param columns the columns
	 * 
	 * @return the new row
	 */
	/*package*/ Row copy(Row parent, Column[] columns) {
		Row copy = new Row(parent, columns, null);
		for (int i = 0; i < this.columns.length; i++) {
			Column origColumn = this.columns[i];
			Column copiedColumn = columns[i];
			copy.setCellContent(copiedColumn, getCellContent(origColumn));
		}
		copy.parameters = new HashMap<>(this.parameters);
		
		Row[] rowsToCopy = getRows();
		for (Row rowToCopy : rowsToCopy) {
			copy.rows.add(rowToCopy.copy(copy, columns));
		}
		return copy;
	}
	
	/**
	 * @return the additional parameters of the given row
	 */
	public Map<String, Object> getParameters() {
		return parameters;
	}
	
	/**
	 * @return the assigned data object of the given row
	 */
	public Object getData() {
		return data;
	}
	
	/**
	 * Assigns the given data to this row.
	 * 
	 * @param data the data
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String separator = ""; //$NON-NLS-1$
		for (Column column : columns) {
			Object content = getCellContent(column);
			sb.append(separator).append(content);
			separator = ", "; //$NON-NLS-1$
		}
		return sb.toString();
	}
	
}
