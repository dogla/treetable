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

/**
 * The bean indentifying a column of the {@link TreeTable} structure.
 *
 * @author Dominik Glaser
 */
public class Column {
	
	private String label;
	private ColumnAlignment alignment;
//	private Map<String, Object> parameters = new HashMap<>();
	
	/**
	 * Constructor.
	 *
	 * @param label the label
	 */
	public Column(String label) {
		this(label, ColumnAlignment.LEFT);
	}
	
	/**
	 * Constructor.
	 *
	 * @param label the label
	 * @param alignment the alignment
	 */
	public Column(String label, ColumnAlignment alignment) {
		super();
		this.label = label;
		this.alignment = alignment;
	}
	
	/**
	 * Copy constructor.
	 *
	 * @param column the column
	 */
	public Column(Column column) {
		this.label = column.label;
		this.alignment = column.alignment;
//		this.parameters = new HashMap<>(column.parameters);
	}

	/**
	 * @return the label of the column
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * @return the alignment of the column
	 */
	public ColumnAlignment getAlignment() {
		return alignment;
	}
	
	/**
	 * Sets the alignment of the column.
	 * 
	 * @param alignment the alignment to set
	 */
	public void setAlignment(ColumnAlignment alignment) {
		this.alignment = alignment;
	}
	
	/**
	 * Copies the given column.
	 * 
	 * @return the copy
	 */
	public Column copy() {
		return new Column(this);
	}
	
//	public Map<String, Object> getParameters() {
//		return parameters;
//	}

	@SuppressWarnings("nls")
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Column [label=").append(label).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Column other = (Column) obj;
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		return true;
	}
	
}
