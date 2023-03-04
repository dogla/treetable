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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.github.dogla.treetable.util.RowVisitResult;
import io.github.dogla.treetable.util.RowVisitor;

/**
 * Converter to produce a text representation of a {@link TreeTable}.
 *
 * @author Dominik Glaser
 */
@SuppressWarnings("nls")
public class TreeTableToTextConverter implements TreeTableConverter<String> {

	private boolean printHeader = true;
	private boolean printOuterLines = true;
	private boolean printInnerLines = true;
	
	private String columnSeperator;
	private String treeLineVertical;
	private String treeLineHorizontal;
	private String treeLineChild;
	private String treeLineLastChild;
	private String lineSeperator;
	private String lineSeperatorTopLeft;
	private String lineSeperatorTopMiddle;
	private String lineSeperatorTopRight;
	private String lineSeperatorMiddleLeft;
	private String lineSeperatorCenter;
	private String lineSeperatorMiddleRight;
	private String lineSeperatorBottomLeft;
	private String lineSeperatorBottomMiddle;
	private String lineSeperatorBottomRight;
	
	private Map<Column, Integer> columnWidths = new HashMap<>();
	
	/**
	 * Constructor.
	 */
	public TreeTableToTextConverter() {
		withASCII();
	}
	
	/**
	 * Returns the printHeader.
	 *
	 * @return the printHeader
	 */
	public boolean isPrintHeader() {
		return printHeader;
	}

	/**
	 * Sets the printHeader.
	 *
	 * @param printHeader the printHeader to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withPrintHeader(boolean printHeader) {
		this.printHeader = printHeader;
		return this;
	}

	/**
	 * Returns the printOuterLines.
	 *
	 * @return the printOuterLines
	 */
	public boolean isPrintOuterLines() {
		return printOuterLines;
	}

	/**
	 * Sets the printOuterLines.
	 *
	 * @param printOuterLines the printOuterLines to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withPrintOuterLines(boolean printOuterLines) {
		this.printOuterLines = printOuterLines;
		return this;
	}

	/**
	 * Returns the printInnerLines.
	 *
	 * @return the printInnerLines
	 */
	public boolean isPrintInnerLines() {
		return printInnerLines;
	}

	/**
	 * Sets the printInnerLines.
	 *
	 * @param printInnerLines the printInnerLines to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withPrintInnerLines(boolean printInnerLines) {
		this.printInnerLines = printInnerLines;
		return this;
	}
	
	/**
	 * Returns the columnSeperator.
	 *
	 * @return the columnSeperator
	 */
	public String getColumnSeperator() {
		return columnSeperator;
	}

	/**
	 * Sets the columnSeperator.
	 *
	 * @param columnSeperator the columnSeperator to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withColumnSeperator(String columnSeperator) {
		this.columnSeperator = columnSeperator;
		return this;
	}

	/**
	 * Returns the treeLineVertical.
	 *
	 * @return the treeLineVertical
	 */
	public String getTreeLineVertical() {
		return treeLineVertical;
	}

	/**
	 * Sets the treeLineVertical.
	 *
	 * @param treeLineVertical the treeLineVertical to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withTreeLineVertical(String treeLineVertical) {
		this.treeLineVertical = treeLineVertical;
		return this;
	}

	/**
	 * Returns the treeLineHorizontal.
	 *
	 * @return the treeLineHorizontal
	 */
	public String getTreeLineHorizontal() {
		return treeLineHorizontal;
	}

	/**
	 * Sets the treeLineHorizontal.
	 *
	 * @param treeLineHorizontal the treeLineHorizontal to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withTreeLineHorizontal(String treeLineHorizontal) {
		this.treeLineHorizontal = treeLineHorizontal;
		return this;
	}

	/**
	 * Returns the treeLineChild.
	 *
	 * @return the treeLineChild
	 */
	public String getTreeLineChild() {
		return treeLineChild;
	}

	/**
	 * Sets the treeLineChild.
	 *
	 * @param treeLineChild the treeLineChild to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withTreeLineChild(String treeLineChild) {
		this.treeLineChild = treeLineChild;
		return this;
	}

	/**
	 * Returns the treeLineLastChild.
	 *
	 * @return the treeLineLastChild
	 */
	public String getTreeLineLastChild() {
		return treeLineLastChild;
	}

	/**
	 * Sets the treeLineLastChild.
	 *
	 * @param treeLineLastChild the treeLineLastChild to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withTreeLineLastChild(String treeLineLastChild) {
		this.treeLineLastChild = treeLineLastChild;
		return this;
	}

	/**
	 * Returns the lineSeperator.
	 *
	 * @return the lineSeperator
	 */
	public String getLineSeperator() {
		return lineSeperator;
	}

	/**
	 * Sets the lineSeperator.
	 *
	 * @param lineSeperator the lineSeperator to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withLineSeperator(String lineSeperator) {
		this.lineSeperator = lineSeperator;
		return this;
	}

	/**
	 * Returns the lineSeperatorTopLeft.
	 *
	 * @return the lineSeperatorTopLeft
	 */
	public String getLineSeperatorTopLeft() {
		return lineSeperatorTopLeft;
	}

	/**
	 * Sets the lineSeperatorTopLeft.
	 *
	 * @param lineSeperatorTopLeft the lineSeperatorTopLeft to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withLineSeperatorTopLeft(String lineSeperatorTopLeft) {
		this.lineSeperatorTopLeft = lineSeperatorTopLeft;
		return this;
	}

	/**
	 * Returns the lineSeperatorTopMiddle.
	 *
	 * @return the lineSeperatorTopMiddle
	 */
	public String getLineSeperatorTopMiddle() {
		return lineSeperatorTopMiddle;
	}

	/**
	 * Sets the lineSeperatorTopMiddle.
	 *
	 * @param lineSeperatorTopMiddle the lineSeperatorTopMiddle to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withLineSeperatorTopMiddle(String lineSeperatorTopMiddle) {
		this.lineSeperatorTopMiddle = lineSeperatorTopMiddle;
		return this;
	}

	/**
	 * Returns the lineSeperatorTopRight.
	 *
	 * @return the lineSeperatorTopRight
	 */
	public String getLineSeperatorTopRight() {
		return lineSeperatorTopRight;
	}

	/**
	 * Sets the lineSeperatorTopRight.
	 *
	 * @param lineSeperatorTopRight the lineSeperatorTopRight to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withLineSeperatorTopRight(String lineSeperatorTopRight) {
		this.lineSeperatorTopRight = lineSeperatorTopRight;
		return this;
	}

	/**
	 * Returns the lineSeperatorMiddleLeft.
	 *
	 * @return the lineSeperatorMiddleLeft
	 */
	public String getLineSeperatorMiddleLeft() {
		return lineSeperatorMiddleLeft;
	}

	/**
	 * Sets the lineSeperatorMiddleLeft.
	 *
	 * @param lineSeperatorMiddleLeft the lineSeperatorMiddleLeft to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withLineSeperatorMiddleLeft(String lineSeperatorMiddleLeft) {
		this.lineSeperatorMiddleLeft = lineSeperatorMiddleLeft;
		return this;
	}

	/**
	 * Returns the lineSeperatorCenter.
	 *
	 * @return the lineSeperatorCenter
	 */
	public String getLineSeperatorCenter() {
		return lineSeperatorCenter;
	}

	/**
	 * Sets the lineSeperatorCenter.
	 *
	 * @param lineSeperatorCenter the lineSeperatorCenter to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withLineSeperatorCenter(String lineSeperatorCenter) {
		this.lineSeperatorCenter = lineSeperatorCenter;
		return this;
	}

	/**
	 * Returns the lineSeperatorMiddleRight.
	 *
	 * @return the lineSeperatorMiddleRight
	 */
	public String getLineSeperatorMiddleRight() {
		return lineSeperatorMiddleRight;
	}

	/**
	 * Sets the lineSeperatorMiddleRight.
	 *
	 * @param lineSeperatorMiddleRight the lineSeperatorMiddleRight to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withLineSeperatorMiddleRight(String lineSeperatorMiddleRight) {
		this.lineSeperatorMiddleRight = lineSeperatorMiddleRight;
		return this;
	}

	/**
	 * Returns the lineSeperatorBottomLeft.
	 *
	 * @return the lineSeperatorBottomLeft
	 */
	public String getLineSeperatorBottomLeft() {
		return lineSeperatorBottomLeft;
	}

	/**
	 * Sets the lineSeperatorBottomLeft.
	 *
	 * @param lineSeperatorBottomLeft the lineSeperatorBottomLeft to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withLineSeperatorBottomLeft(String lineSeperatorBottomLeft) {
		this.lineSeperatorBottomLeft = lineSeperatorBottomLeft;
		return this;
	}

	/**
	 * Returns the lineSeperatorBottomMiddle.
	 *
	 * @return the lineSeperatorBottomMiddle
	 */
	public String getLineSeperatorBottomMiddle() {
		return lineSeperatorBottomMiddle;
	}

	/**
	 * Sets the lineSeperatorBottomMiddle.
	 *
	 * @param lineSeperatorBottomMiddle the lineSeperatorBottomMiddle to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withLineSeperatorBottomMiddle(String lineSeperatorBottomMiddle) {
		this.lineSeperatorBottomMiddle = lineSeperatorBottomMiddle;
		return this;
	}

	/**
	 * Returns the lineSeperatorBottomRight.
	 *
	 * @return the lineSeperatorBottomRight
	 */
	public String getLineSeperatorBottomRight() {
		return lineSeperatorBottomRight;
	}

	/**
	 * Sets the lineSeperatorBottomRight.
	 *
	 * @param lineSeperatorBottomRight the lineSeperatorBottomRight to set
	 *
	 * @return the instance itself
	 */
	public TreeTableToTextConverter withLineSeperatorBottomRight(String lineSeperatorBottomRight) {
		this.lineSeperatorBottomRight = lineSeperatorBottomRight;
		return this;
	}

	/**
	 * Uses for the line characters plain ASCII standard characters.
	 * 
	 * @return instance itself 
	 */
	public TreeTableToTextConverter withASCII() {
		columnSeperator = "|";
		lineSeperator = "-";
		lineSeperatorTopLeft = "+";
		lineSeperatorTopMiddle = "+";
		lineSeperatorTopRight = "+";
		lineSeperatorMiddleLeft = "+";
		lineSeperatorCenter = "+";
		lineSeperatorMiddleRight = "+";
		lineSeperatorBottomLeft = "+";
		lineSeperatorBottomMiddle = "+";
		lineSeperatorBottomRight = "+";
		treeLineChild = "+";
		treeLineLastChild = "+";
		treeLineHorizontal = "-";
		treeLineVertical = "|";
		return this;
	}

	/**
	 * Uses for the line characters the extended ASCII line characters.
	 * 
	 * @return instance itself 
	 */
	public TreeTableToTextConverter withASCIIExtended() {
		columnSeperator = "│";
		lineSeperator = "─";
		lineSeperatorTopLeft = "┌";
		lineSeperatorTopMiddle = "┬";
		lineSeperatorTopRight = "┐";
		lineSeperatorMiddleLeft = "├";
		lineSeperatorCenter = "┼";
		lineSeperatorMiddleRight = "┤";
		lineSeperatorBottomLeft = "└";
		lineSeperatorBottomMiddle = "┴";
		lineSeperatorBottomRight = "┘";
		treeLineChild = "├";
		treeLineLastChild = "└";
		treeLineHorizontal = "─";
		treeLineVertical = "│";
		return this;
	}
	
	
	@Override
	public String convert(TreeTable treeTable) {
		TreeTable tt = treeTable.copy();
		if (tt.isTree()) {
			initTreeStructure(tt);
		}
		initIndentStructure(tt);
		Column[] columns = tt.getColumns();
		initColumnWidths(tt);
		
		StringBuilder sb = new StringBuilder();
		if (isPrintHeader()) {
			if (isPrintOuterLines()) {
				sb.append(separator(columns, lineSeperator, lineSeperatorTopLeft, lineSeperatorTopMiddle, lineSeperatorTopRight));
			}
			sb.append(line(columns, c -> {
				return c.getLabel();
			}));
		}
		if (isPrintHeader() && isPrintOuterLines()) {
			sb.append(separator(columns, lineSeperator, lineSeperatorMiddleLeft, lineSeperatorCenter, lineSeperatorMiddleRight));
		} else if (isPrintHeader()) {
			sb.append(separator(columns, lineSeperator, lineSeperatorMiddleLeft, lineSeperatorCenter, lineSeperatorMiddleRight));
		} else if (isPrintOuterLines()) {
			sb.append(separator(columns, lineSeperator, lineSeperatorTopLeft, lineSeperatorTopMiddle, lineSeperatorTopRight));
		}

		tt.walk(row -> {
			sb.append(line(columns, c -> {
				return getCellContent(row, c);
			}));
			return RowVisitResult.CONTINUE;
		});
		
		if (isPrintOuterLines()) {
			sb.append(separator(columns, lineSeperator, lineSeperatorBottomLeft, lineSeperatorBottomMiddle, lineSeperatorBottomRight));
		}
		return sb.toString();
	}

	private void initColumnWidths(TreeTable tt) {
		Column[] columns = tt.getColumns();
		for (Column column : columns) {
			int[] width = new int[] { column.getLabel().length() };
			tt.walk(new RowVisitor() {
				@Override
				public RowVisitResult visitRow(Row row) {
					Object cellContent = getCellContent(row, column);
					String cell = cellContent != null ? cellContent.toString() : "";
					int w = cell.length();
					if (w > width[0]) {
						width[0] = w;
					}
					return RowVisitResult.CONTINUE;
				}
			});
			columnWidths.put(column, width[0]);
		}
	}
	
	private int getWidth(Column column) {
		Integer i = columnWidths.get(column);
		if (i != null) {
			return i;
		}
		return 0;
	}
	
	private static String getCellContent(Row row, Column column) {
		Object cellContent = row.getCellContent(column);
		return cellContent != null ? cellContent.toString() : "";
	}
	
	private void initTreeStructure(TreeTable treeTable) {
		Column[] columns = treeTable.getColumns();
		Column firstColumn = columns[0];
		// first column should be aligned to the left
		firstColumn.setAlignment(ColumnAlignment.LEFT);
		// sort rows (folder like rows first)
		sortRows(treeTable);
		// add prefixes to visualize the tree structure
		addTreeStructure(firstColumn, treeTable.getRows(), "");
	}
	
	private static void initIndentStructure(TreeTable treeTable) {
		Column[] columns = treeTable.getColumns();
		treeTable.walk(row -> {
			for (Column column : columns) {
				String cellContent = getCellContent(row, column);
				if (!cellContent.isEmpty()) {
					Object value = row.getParameters().get(column.getLabel()+"#indent");
					if (value != null) {
						try {
							int i = Integer.parseInt(value.toString());
							if (i > 0) {
								String indent = "  ".repeat(i);
								if (ColumnAlignment.LEFT.equals(column.getAlignment())) {
									row.setCellContent(column, indent + cellContent);
								} else if (ColumnAlignment.RIGHT.equals(column.getAlignment())) {
									row.setCellContent(column, cellContent + indent);
								}
							}
						} catch (NumberFormatException e) {
							// we ignore a wrong number format here
						}
					}
				}
			}
			return RowVisitResult.CONTINUE;
		});
	}
	
	private void sortRows(TreeTable treeTable) {
		treeTable.sort((r1, r2) -> {
			int i1 = r1.hasRows() ? 1 : 0;
			int i2 = r2.hasRows() ? 1 : 0;
			return i2-i1;
		});
		Row[] rows = treeTable.getRows();
		for (Row row : rows) {
			sortRows(row);
		}
	}

	private void sortRows(Row row) {
		row.sort((r1, r2) -> {
			int i1 = r1.hasRows() ? 1 : 0;
			int i2 = r2.hasRows() ? 1 : 0;
			return i2-i1;
		});
		Row[] rows = row.getRows();
		for (Row childRow : rows) {
			sortRows(childRow);
		}
	}
	
	private void addTreeStructure(Column firstColumn, Row[] rows, String prefix) {
		for (int i = 0; i < rows.length; i++) {
			Row row = rows[i];
			boolean isFirstLevel = row.depth() == 1;
			boolean isLastRow = i == rows.length - 1;
			addTreeStructure(firstColumn, row.getRows(), prefix + (isFirstLevel ? "" : (isLastRow ? "    " : treeLineVertical + "  ")));
			String p = isFirstLevel ? "" : (isLastRow ? treeLineLastChild : treeLineChild) + treeLineHorizontal + treeLineHorizontal + " " ; 
			row.setCellContent(firstColumn, prefix + p + getCellContent(row, firstColumn));
		}
	}
	
	private String separator(Column[] columns, String lineSeperator, String lineSeperatorMiddleLeft, String lineSeperatorCenter, String lineSeperatorMiddleRight) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.length; i++) {
			Column column = columns[i];
			if (isPrintOuterLines()) {
				if (i == 0) {
					sb.append(lineSeperatorMiddleLeft).append(lineSeperator);
				}
			}
			sb.append(lineSeperator.repeat(getWidth(column)));
			if (i == columns.length-1) {
				if (isPrintOuterLines()) {
					sb.append(lineSeperator).append(lineSeperatorMiddleRight);
				}
			} else {
				if (isPrintInnerLines()) {
					sb.append(lineSeperator).append(lineSeperatorCenter).append(lineSeperator);
				} else {
					sb.append(lineSeperatorCenter);
				}
			}
		}
		sb.append("\n");
		return sb.toString();
	}
	
	private String line(Column[] columns, Function<Column, String> cellTextProvider) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.length; i++) {
			Column column = columns[i];
			if (isPrintOuterLines()) {
				if (i == 0) {
					sb.append(columnSeperator).append(" ");
				}
			}
			String label = cellTextProvider.apply(column);
			if (label == null) {
				label = "";
			}
			// TODO handle new lines
			label = label.replaceAll("\r", "");
			label = label.replaceAll("\n", " ");
			int gap = getWidth(column) - label.length();
			switch (column.getAlignment()) {
				case CENTER:
					sb.append(" ".repeat((int)Math.floor(gap/2.0)));
					sb.append(label);
					sb.append(" ".repeat((int)Math.ceil(gap/2.0)));
					break;
				case LEFT:
					sb.append(label);
					sb.append(" ".repeat(gap));
					break;
				case RIGHT:
					sb.append(" ".repeat(gap));
					sb.append(label);
					break;
			}
			if (i == columns.length-1) {
				if (isPrintOuterLines()) {
					sb.append(" ").append(columnSeperator);
				}
			} else {
				if (isPrintInnerLines()) {
					sb.append(" ").append(columnSeperator).append(" ");
				} else {
					sb.append(" ");
				}
			}
		}
		sb.append("\n");
		return sb.toString();
	}
	
}
